class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int maxNum = n;
        int result = 0;

        int[][] map = getMap(n, edges);
        for (int start = 0; start < n; start++) {
            int num = getNumberOfCities(n, map, distanceThreshold, start);
            if (num <= maxNum) {
                maxNum = num;
                result = start;
            }
        }
        return result;
    }

    private int[][] getMap(int n, int[][] edges) {
        int[][] map = new int[n][n];
        for (int i = 0; i < map.length; i++) Arrays.fill(map[i], Integer.MAX_VALUE / 2);

        for (int i = 0; i < map.length; i++) map[i][i] = 0;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int distance = edge[2];
            map[from][to] = distance;
            map[to][from] = distance; 
        }

        // trick -> Floyd-Warshall algorithm
        //          this is dp like backpack solution
        for (int mid = 0; mid < n; mid++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    map[from][to] = Math.min(map[from][to], map[from][mid] + map[mid][to]);
                }
            }
        }
        return map;
    }

    private int getNumberOfCities(int n, int[][] map, int threshold, int start) {
        int counter = 0;
        for (int distance : map[start]) {
            if (distance > 0 && distance <= threshold) counter++;                    
        }
        return counter;
    }
}