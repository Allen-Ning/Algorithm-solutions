class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);

        int counter = 1;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[1] <= prev[1]) continue;
            prev = current;
            counter++;
        }
        return counter;
    }
}