class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // trick -> sort by end to make it more clear to understand
        //          the idea is to make the end as smaller as possible to fit in more interval
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