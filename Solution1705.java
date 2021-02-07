class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        int n = apples.length;
        int result = 0;
        int day = 0;
        while (day < n || minHeap.size() > 0) {
            if (day < n && apples[day] > 0) minHeap.add(new int[] {apples[day], day + days[day]});

            int[] appleToBeExpired = minHeap.poll();
            while (appleToBeExpired != null && appleToBeExpired[1] <= day) appleToBeExpired = minHeap.poll();

            if (appleToBeExpired != null) {
                appleToBeExpired[0] -= 1;
                result++;
                if (appleToBeExpired[0] > 0 && appleToBeExpired[1] > day)  minHeap.add(appleToBeExpired);
            }
            day++;
        }
        return result;
    }
}