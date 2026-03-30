// trick -> This question is very hard to implement. It might have to list all the corner case.
//          There are 3 parts:
//          intervals - mergedIntervals - intervals
//
//          The corner case - the intervals is empty
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            results.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0]; = Math.min(intervals[i][0], newInterval[0];);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        results.add(newInterval);

        while (i < intervals.length) results.add(intervals[i++]);

        int[][] finalResults = new int[results.size()][2];
        for (int j = 0; j < results.size(); j++) {
            finalResults[j] = results.get(j);
        }
        return finalResults;
    }
}
