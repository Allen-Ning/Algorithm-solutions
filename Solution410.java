class Solution {
    public int splitArray(int[] nums, int m) {
        // trick -> the min value will the max num
        //          due to we at least make the largest num as the smallest individaul group
        int min = 0;
        int max = 0;

        for (int num : nums) {
            max += num;
            min = Math.max(min, num);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            int groupSize = calcM(nums, mid);
            if (groupSize > m) {
                min = mid + 1;
            } else if (groupSize <= m) {
                max = mid;
            }
        }
        return min;        
    }

    // trick -> counter 1 as default
    private int calcM(int[] nums, int valuePerGroup) {
        int group = 0;
        int counter = 1;
        for (int num : nums) {
            if (group + num > valuePerGroup) {
                counter++;
                group = num;
            } else {
                group += num;
            }
        }
        return counter;
    }
}
