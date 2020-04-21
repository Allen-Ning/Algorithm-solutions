class Solution {
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0, k});
        // trick -> visited array allowing multiple access
        //          as long as the current node having a better K (currentK > visited[x][y])
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) Arrays.fill(visited[i], -1);
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                if (current[0] == grid.length - 1 && current[1] == grid[0].length - 1) return step;
                for (int[] dir : dirs) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    int currentK = current[2];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                        if (grid[x][y] == 1) currentK--;
                        if (currentK > visited[x][y]) {
                            queue.offer(new int[]{x, y, currentK});
                            visited[x][y] = currentK;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
