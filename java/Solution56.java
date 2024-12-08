class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (num1, num2) -> num1[0] == num2[0] ? num1[1] - num2[1] : num1[0] - num2[0]);
        List<int[]> results = new ArrayList();
        int[] prev = intervals[0];
        // trick -> add the prev to results first and merge the new interval to prev if needed
        results.add(prev);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            // not merge
            if (prev[1] < current[0]) {
                prev = current;
                results.add(current);
                continue;
            }

            prev[1] = Math.max(current[1], prev[1]);
        }

        int[][] finalResults = new int[results.size()][2];
        for (int i = 0; i < results.size(); i++) {
            finalResults[i] = results.get(i);
        }
        return finalResults;
    }
}