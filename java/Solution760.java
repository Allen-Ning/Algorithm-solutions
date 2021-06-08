class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);

        int[] results = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) results[i] = map.get(nums1[i]);
        return results;
    }
}