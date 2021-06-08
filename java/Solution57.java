// trick -> This question is very hard to implement.  It might have to list all the corner case.
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> results = new ArrayList();

        int start = newInterval[0];
        int end = newInterval[1];
        int[] mergedResult = newInterval;

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                results.add(interval);
            } else if (newInterval[1] < interval[0]) {
                if (mergedResult != null) {
                    results.add(mergedResult);
                    mergedResult = null;
                }
                results.add(interval);
            } else {
                start = Math.min(start, Math.min(interval[0], newInterval[0]));
                end = Math.max(end, Math.max(interval[1], newInterval[1]));
                mergedResult = new int[] {start, end};
            }
        }

        if (mergedResult != null) results.add(mergedResult);
        int[][] finalResults = new int[results.size()][2];
        for (int i = 0; i < results.size(); i++) {
            finalResults[i] = results.get(i); 
        }
        return finalResults;
    }
}
