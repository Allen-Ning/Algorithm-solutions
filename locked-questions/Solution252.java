public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // trick -> this is to handle special case intervals is empty
        if (intervals.length == 0) return true;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (prev[1] > current[0]) return false;
            prev = current;
        }
        return true;
    }
}