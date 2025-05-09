class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // trick -> We need to sort the end time rather than the start time. This approach works because:
        //          1. By sorting by end time, we maximize the room for future intervals
        //          2. When faced with overlapping intervals, we always choose the one that ends earlier

        //  one of the example is below:
        //  [-63,2], [-62, -49], [1, 2]
        Arrays.sort(intervals, (a, b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);

        int[] prev = intervals[0];
        int counter = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] < prev[1]) {
                counter++;
            } else {
                prev = current;
            }
        }
        return counter;
    }
}