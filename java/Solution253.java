class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (r1, r2) -> r1[0] - r2[0]);
        // trick -> syntax
        PriorityQueue<int[]> heap = new PriorityQueue<>((r1, r2) -> r1[1] - r2[1]);

        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // trick -> we cannot peek and modify,
            //          it will not update the order of the heap
            //          e.g  int[] prev = heap.peek();
            //               prev[1] = intervals[i][1]
            //          the above one will not be working

            int[] prev = heap.poll();
            if (prev[1] <= intervals[i][0]) {
                prev[1] = intervals[i][1];
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(prev);
        }
        return heap.size();
    }
}