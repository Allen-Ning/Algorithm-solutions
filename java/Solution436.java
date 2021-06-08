class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;
        TreeMap<Integer, Integer> map = new TreeMap();

        int[] interval = null;
        for (int i = 0; i < intervals.length; i++) {
            interval = intervals[i];
            map.put(interval[0], i);
        }

        int[] results = new int[intervals.length]; 
        for (int i = 0; i < intervals.length; i++) {
            interval = intervals[i];
            Integer key = map.ceilingKey(interval[1]); 
            results[i] = (key == null ? -1 : map.get(key));
        }

        return results;
    }
}
