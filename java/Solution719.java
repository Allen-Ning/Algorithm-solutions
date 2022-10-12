class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = -1;
        int right = nums[nums.length - 1] - nums[0] + 1;
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            int counter = 0;

            for (int i = 0; i < nums.length; i++) {
                int pos = bs(nums, nums[i] + mid);
                // trick -> be careful to caculate the counter
                counter += pos - i;
            }

            if (counter < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int bs(int[] nums, int value) {
        int left = -1;
        int right = nums.length;

        while (left + 1 != right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= value) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}