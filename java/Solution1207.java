class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int value : arr) map.put(value, map.getOrDefault(value, 0) + 1);

        Set<Integer> set = new HashSet();
        // trick -> map api values()
        for (int value : map.values()) {
            if (!set.add(value)) return false;
        }
        return true;
    }
}