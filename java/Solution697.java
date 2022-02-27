class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        HashMap<Integer, int[]> map = new HashMap();
        int maxFrequence = 0;
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] value = map.get(num);
            if (value == null) {
                // frequence, minIndex, maxIndex
                value = new int[]{1, i, i};   
            } else {
                value = new int[]{value[0] + 1, value[1], i};
            }
            map.put(num, value);

            if (value[0] > maxFrequence) {
                maxFrequence = value[0];
                result = value[2] - value[1] + 1;
            } else if (value[0] == maxFrequence) {
                result = Math.min(result, value[2] - value[1] + 1);
            }
        }

        return result;
    }
}