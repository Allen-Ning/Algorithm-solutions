class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // set1, set2
        Set<Integer> set1 = new HashSet();
        for (int num : nums1) set1.add(num);
        Set<Integer> set2 = new HashSet();
        for (int num : nums2) set2.add(num);

        // set1 check set2
        List<Integer> list1 = new ArrayList();
        for (int value : set1) {
            if (!set2.contains(value)) list1.add(value);
        }

        // set2 check set1
        List<Integer> list2 = new ArrayList();
        for (int value : set2) {
            if (!set1.contains(value)) list2.add(value);
        }

        ArrayList<List<Integer>> result = new ArrayList();
        result.add(list1);
        result.add(list2);
        return result;
    }
}