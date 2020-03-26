class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        Queue<int[]> queue = new LinkedList();
        int total = 0;
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) total++;
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                    counter++;
                }
            }
        }

        if (total == counter) return 0;

        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        while (!queue.isEmpty()) {
            if (total == counter) return step;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if (x >= 0 &&
                        y >= 0 &&
                        x < grid.length &&
                        y < grid[0].length &&
                        grid[x][y] == 1
                       ) {
                        grid[x][y] = 2;
                        queue.offer(new int[] {x, y});
                        counter++;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
