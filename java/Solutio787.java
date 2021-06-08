class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[][] graph = new int[n][n];
        for (int[] flight : flights) graph[flight[0]][flight[1]] = flight[2];

        // trick -> this is basically a priority queue question,
        //          we use K + 1 to remember remainStops for all possible solution in queue
        queue.offer(new int[] {src, 0, K + 1});
        while (!queue.isEmpty()) {
            int[] travel = queue.poll();
            int start = travel[0];
            int price = travel[1];
            int leftStep = travel[2];
            if (start == dst) return price;

            for (int next = 0; next < graph[start].length; next++) {
                if (graph[start][next] == 0) continue;
                int nextStop = leftStep - 1;
                if (nextStop >= 0) queue.offer(new int[] {next, price + graph[start][next], nextStop});
            }
        }
        return -1;
    }
}
