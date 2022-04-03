class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // trick -> avoid this corner cases: 
            //          e.g. [-1,0,1,2,-1,-4]
            //               [-4,-1,-1, 0, 1, 2]
            //               (-1, 0, 1)               
            if (i >= 1 && nums[i] == nums[i - 1]) continue;

            int lookUp = nums[i] * -1;
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                if (nums[start] + nums[end] < lookUp) {
                    start++;
                    continue;
                } else if (nums[start] + nums[end] > lookUp) {
                    end--;
                    continue;
                }

                List<Integer> result = new ArrayList();
                result.add(nums[i]);
                result.add(nums[start++]);
                result.add(nums[end--]);
                results.add(result);
                while (start - 1 > 0 && start < end && nums[start] == nums[start - 1]) start++;
                while (end > start && end + 1 < nums.length && nums[end] == nums[end + 1]) end--;
            }
        }
        return results;
    }
}