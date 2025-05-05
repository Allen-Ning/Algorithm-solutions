class Solution {
    public int maxArea(int[] height) {
        /**
            area = Math.min(left, right) * (indexes gap)

            e.g. [1,8,6,2,5,4,8,3,7]
            1. compare index 0 with value 1 and index length - 1 with value 7
            2. choose index 0 cos 1 < 7
            3. max area = Math.Max(the max area including index 0, the max area not including index 0)
            4. calculate the max area including index 0 = Math.min(1, 7) * (length - 1) = 1 * 8 = 8
            5. max area = Math.Max(8, the max area not including index 0 as unknown)
            6. the max area not including index 0 = Max(the max area including index length - 1, the max area not including index index length - 1)
            7. choose index length - 1 cos 7 > 8
            8. calculate the max area including index length - 1 = Math.min(8, 7) * (length - 1 - 1) = 7 * 7 = 49
            9. max area = Math.max(49, the max area not including index length - 1 as unknown)
            10. repeat the process above


            pick one from the most left,
            pick one from the most right,
            because the indexes gap are the largest

            cos we can only move left or right

            we would like to keep min as big as possible

            given indexes gap is decreasing by nature, we need to find the biggest min if possible

            key trick -> the question is to use divide and conquer thinking,
            after we remove the most left or the most right, we keep reducing the problem into a subproblem

            e.g. a < g and |abcdefg|, a subproblem is |bcdefg| or |abcdef|
            1. pick the most left or the most right to be remove, which a or g
            2. with a, the max area we could get with a is a * (g - a) because g - a is the largest gap,
               we will then record the max area with a and remove a, cos a is not the decision factor for the problem anymore given a < g
            3. after we remove a, we transform the original problem into a subproblem |abcdefg| -> |bcdefg|,
                because for the another subproblem |abcdef| or any subproblem including a,
                  * if a is decison factor (the shortest one), which should be smaller than the area of |abcdefg|, so we can remove a
                  * if a is not a decision factor (the shortest one), |abcdef| should be smaller than the area of |abcdefg| as well
            4. keep repeat the process to remove the most left or the most right from the subproblem
         */
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        while (i < j) {
            int width = j - i;
            int minHeight = Math.min(height[i], height[j]);
            result = Math.max(result, width * minHeight);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }
}