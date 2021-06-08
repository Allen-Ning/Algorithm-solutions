class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0 || capacity == 0) return false;

        Map<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < trips.length; i++) {
            map.put(trips[i][1], map.getOrDefault(trips[i][1], 0) + trips[i][0]);
            map.put(trips[i][2], map.getOrDefault(trips[i][2], 0) - trips[i][0]);
        }

        int current = 0;
        for (int value : map.values()) {
            current += value;
            if (current > capacity) return false;
        }
        return true;
    }
}
