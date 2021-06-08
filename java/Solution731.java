class MyCalendarTwo {

    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += entry.getValue();
            if (result == 3) {
                int value = map.getOrDefault(start, 0) - 1;
                if (value == 0) {
                    map.remove(start);
                } else {
                    map.put(start, map.getOrDefault(start, 0) - 1);
                }

                value = map.getOrDefault(end, 0) + 1;
                if (value == 0) {
                    map.remove(end);
                } else {
                    map.put(end, map.getOrDefault(end, 0) + 1);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
