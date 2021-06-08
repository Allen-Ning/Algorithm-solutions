class SparseVector {
    private HashMap<Integer, Integer> map;

    SparseVector(int[] nums) {
        map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            map.put(i, nums[i]);
        }
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        HashMap<Integer, Integer> map2 = vec.map;
        if (map.size() > map2.size()) {
            HashMap<Integer, Integer> temp = null;
            temp = map2;
            map2 = map;
            map = temp;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (!map2.containsKey(key)) continue;
            result += map.get(key) * map2.get(key);
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);