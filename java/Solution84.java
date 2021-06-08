class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        // trick -> index as element
        Stack<Integer> s = new Stack();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            // trick -> add 0 as the last elemnt to clear up the stack
            int height =  (i != heights.length) ? heights[i] : 0;
            if (s.empty() || heights[s.peek()] <= height) {
                s.push(i);
            } else {
                int index = s.pop();
                // trick -> special case for the smalles element
                // when stack is empty, the smallest one left boundary is 0
                // right boundary the array length - 1
                if (s.empty()) {
                    max = Math.max(i * heights[index], max);
                } else {
                    // trick -> canot use i - index
                    // must use i - 1 - s.peek()
                    // e.g. [4,2,0,3,2,5]
                    max = Math.max((i - 1 - s.peek()) * heights[index], max);
                }
                i--;
            }
        }
        return max;
    }
}
