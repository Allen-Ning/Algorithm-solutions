class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int maxNum = n;
        int[][] map = new int[n][n];
        int result = 0;

        for (int from = 0; from < n; from++) Arrays.fill(map[from], Integer.MAX_VALUE / 2);

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int distance = edge[2];
            map[from][to] = distance;
            map[to][from] = distance;
        }

        for (int start = 0; start < n; start++) {
            int num = getNumberOfCities(n, map, distanceThreshold, start);

            if (num <= maxNum) {
                maxNum = num;
                result = start;
            }
        }
        return result;
    }

    private int getNumberOfCities(int n, int[][] map, int threshold, int start) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE / 2);
        distances[start] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // trick -> add started start city
        //          [reachedCity, distanceToReachedCity]
        //          distanceToReachedCity -> from starting point to the reached city
        minHeap.offer(new int[] {start, 0});

        // trick -> add the rest reached city
        //          the minheap will always popup current nearest city reached from starting point
        //          e.g. [A, 12] (means from starting point to A, distance is 12)
        //               [B, 16] (means from starting point to B, distance is 16)
        //               [C, 20] (means from starting point to C, distance is 20)
        //          [A, 12] will be popped from the above example
        while (minHeap.size() > 0) {
            int[] city = minHeap.poll();
            int reachedCity = city[0];
            int distanceToReachedCity = city[1];
            // trick -> the mininium reached city is over threshold
            //          there is no need to check more
            if (distanceToReachedCity > threshold) break;

            int from = reachedCity;
            for (int to = 0; to < n; to++) {
                int distanceFromReachedCityToUnvisitedCity = map[from][to];
                if (distanceToReachedCity + distanceFromReachedCityToUnvisitedCity < distances[to]) {
                    distances[to] = distanceToReachedCity + distanceFromReachedCityToUnvisitedCity;
                    // trick -> we could have a map and
                    //          keep only the current nearest distance from starting point to the reached city
                    //          so that we will avoid to delete greater distance from starting point to the reached city in the min-heap as o(n) operation
                    //          as a workaround implementation for dijkstra algorithm
                    //          but this is not necessary for this problem due to we will return if (distanceToReachedCity > threshold) break;
                    minHeap.offer(new int[] {to, distances[to]});
                }
            }
        }

        int counter = 0;
        for (int distance : distances) {
            if (distance > 0 && distance <= threshold) counter++;
        }
        return counter;
    }
}