class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int target = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int value = nums[start] + nums[end];
                if (value == target) {
                    ArrayList<Integer> result = new ArrayList();
                    result.add(nums[i]);
                    result.add(nums[start]);
                    result.add(nums[end]);
                    list.add(result);
                    start++;
                    while (start < nums.length - 1 && nums[start] == nums[start - 1]) start++;
                    end--;
                    while (end > 0 && nums[end] == nums[end + 1]) end--;
                } else if (value < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return list;
    }
}
