class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int result = 0;
        int mod = (int)1e9 + 7;

        // trick -> nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //          nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        for (int num : nums) {
            int value = num - rev(num);
            int freq = map.getOrDefault(value, -1) + 1;
            map.put(value, freq);
            // trick -> calculate pair frequency
            result += freq;
            result %= mod;
        }
        return result;
    }

    private int rev(int num) {
        int result = 0;
        while (num > 0) {
            int reminder = num % 10;
            num /= 10;
            result = result * 10 + reminder;
        }
        return result;
    }
}