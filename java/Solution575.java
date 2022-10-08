class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // trick -> sort by the end of intervals increasing and then sort by the start of interval decreasing
        //          e.g. [[1,3],[3,7],[5,7],[7,8]]
        Arrays.sort(intervals, (n1, n2) -> n1[1] == n2[1] ? n2[0] - n1[0] : n1[1] - n2[1]);
        int result = 2;
        int p1 = intervals[0][1] - 1;
        int p2 = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (p1 >= current[0]) {
                // two point overlap
                continue;
            } else if (p2 >= current[0]) {
                // one point overlap
                p1 = p2;
                p2 = current[1];
                result++;
            } else {
                // no overlap
                result += 2;
                p1 = current[1] - 1;
                p2 = current[1];
            }
        }
        return result;
    }
}