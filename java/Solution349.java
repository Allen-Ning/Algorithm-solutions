class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        for (int i = 0; i < nums1.length; i++) set1.add(nums1[i]);

        Set<Integer> set2 = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) set2.add(nums2[i]);
        }

        int[] results = new int[set2.size()];
        int counter = 0;
        for (Integer num : set2) results[counter++] = num;
        return results;
    }
}