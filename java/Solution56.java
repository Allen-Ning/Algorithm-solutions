class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);

        ArrayList<int[]> list = new ArrayList();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (prev[1] < current[0]) {
                list.add(prev);
                prev = current;
            } else {
                // trick -> we need max here for the end
                prev[1] = Math.max(prev[1], current[1]);
            }
        }

        // trick -> easy to forget to add the last element
        list.add(prev);
        int[][] results = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }
        return results;
    }
}