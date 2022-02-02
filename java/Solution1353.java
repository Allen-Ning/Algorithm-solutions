class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);

        int endDay = events[events.length - 1][1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[1] == e2[1] ? e1[0] - e2[0] : e1[1] - e2[1]);
        int index = 0;
        int result = 0;

        for (int day = 1; day <= 1e5; day++) {
            while (index < events.length && events[index][0] <= day) {
                queue.offer(events[index]);
                index++;
            }

            while (queue.size() > 0) {
                int[] event = queue.poll();
                if (event[1] < day) continue;
                result++;
                break;
            }
        }
        return result;
    }
}