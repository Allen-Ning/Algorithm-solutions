class Solution {
    /*
        3 follow-up questions:

        1. What if the given array is already sorted? How would you optimize your algorithm?

        sort two array and two pointers

        2. What if nums1's size is small compared to nums2's size? Which algorithm is better?

        hashmap is better than sort two array and two pointers

        3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

        If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.
        If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> list = new HashMap();
        ArrayList<Integer> result = new ArrayList();
        for (int num: nums1) {
            Integer value = list.get(num);
            if (value == null) {
                list.put(num, 1);
            } else {
                list.put(num, ++value);
            }
        }

        for (int num: nums2) {
            Integer value = list.get(num);
            if (value == null) {
                 list.put(num, -1);
            } else {
                if (value > 0) result.add(num);
                list.put(num, --value);
            }
        }
            
        int[] finalResults = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResults[i] = result.get(i);
        }
        return finalResults;
    }
}
