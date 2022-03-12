class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int lookup = target - num;
            Integer preLookupIndex = map.get(lookup);
            if (preLookupIndex != null) return new int[]{preLookupIndex, i};

            // trick -> this could easily handle duplicated case:
            //          [3, 2, 3]
            map.put(num, i);
        }
        return null; 
    }
}