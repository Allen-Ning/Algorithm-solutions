class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] count = new int[1001];

        for (int num : nums) count[num] += 1;
        
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != 1) continue;

            return i;
        }
        return -1;
    }
}