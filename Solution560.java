class Solution {
    public int subarraySum(int[] nums, int k) {
        // e.g1 
        // [1, 1, 1]
        // [1, 2, 3]

        // e.g2
        // [0, 1, 1, 1]
        // [0, 1, 2, 3] 
        // current sum - previous sum = k
        // current sum - k = previous sum 
        int counter = 0;
        HashMap<Integer, Integer> preSumFrequency = new HashMap();
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (currentSum == k) counter++;
            if (preSumFrequency.containsKey(currentSum - k)) counter += preSumFrequency.get(currentSum - k);

            if (preSumFrequency.containsKey(currentSum)) {
                preSumFrequency.put(currentSum, preSumFrequency.get(currentSum) + 1);
            } else {
                preSumFrequency.put(currentSum, 1);
            }
        }
        return counter;
    }
}
