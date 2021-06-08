class MyCalendar {

    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        this.map = new TreeMap();
    }

    public boolean book(int start, int end) {
        int acutalEnd = end - 1;

        Map.Entry<Integer, Integer> lowEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceilEntry = map.ceilingEntry(start);

        if (lowEntry != null && start <= lowEntry.getValue()) return false;

        if (ceilEntry != null && acutalEnd >= ceilEntry.getKey()) return false;

        map.put(start, acutalEnd);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
