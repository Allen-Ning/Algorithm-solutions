/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // trick -> this is to handle special case intervals is empty
        if (intervals.size() == 0) return true;

        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (prev.end > current.start) return false;
            prev = current;
        }
        return true;
    }
}
