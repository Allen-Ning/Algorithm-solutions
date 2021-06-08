/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList();
        if(intervals == null || intervals.size() == 0) return list;
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
         int min = intervals.get(0).start;
        int max = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
          int currentMin = intervals.get(i).start;
          int currentMax = intervals.get(i).end;
          if (currentMin <= max) {
            max = Math.max(currentMax, max);
          } else {
            list.add(new Interval(min, max));
            min = currentMin;
            max = currentMax;
          }
        }
        list.add(new Interval(min, max));
        return list;
    }
}
