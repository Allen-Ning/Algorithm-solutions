class Solution {
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
