class SummaryRanges {
    TreeMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap();
    }

    public void addNum(int val) {
        Integer floorKey = map.floorKey(val);
        int preMax = -1;
        if (floorKey != null) preMax = map.get(floorKey);
        Integer ceilingKey = map.ceilingKey(val);
        int nextMax = -1;
        if (ceilingKey != null) nextMax = map.get(ceilingKey);

        // trick -> list all the possible scenarios
        if (preMax >= val) {
            return;
        } else if (ceilingKey != null && ceilingKey == val) {
            return;
        } else if (floorKey != null &&
                   ceilingKey != null &&
                   val == preMax + 1 &&
                   val == ceilingKey - 1) {
            map.remove(floorKey);
            map.remove(ceilingKey);
            map.put(floorKey, nextMax);
        } else if (floorKey != null && val == preMax + 1) {
            map.put(floorKey, val);
        } else if (ceilingKey != null && val == ceilingKey - 1) {
            map.remove(ceilingKey);
            map.put(val, nextMax);
        } else {
            map.put(val, val);
        }
    }

    public int[][] getIntervals() {
        int[][] results = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] result = new int[] {entry.getKey(), entry.getValue()};
            results[index++] = result;
        }
        return results;
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
