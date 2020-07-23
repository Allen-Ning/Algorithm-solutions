class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] nums = new int[1001];
        for (int val : target) nums[val] += 1;

        for (int val : arr) {
            if (nums[val] == 0) return false;
            nums[val] -= 1;
        }
        return true;
    }
}
