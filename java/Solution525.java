class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // [0, 1, 0, 1, 0, 0, 1]

        // replace 0 to -1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        //  [-1, 1, -1, 1, -1, -1, 1]
        int result = 0;
        int currentSum = 0;
        // sum -> index
        int firstOccurIndex = -1;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum == 0) {
                result = Math.max(result, i + 1);
                continue;
            }

            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
                firstOccurIndex = i;
            } else {
                firstOccurIndex = map.get(currentSum);
            }
            result = Math.max(i - firstOccurIndex, result);
        }
        return result;
    }
}
