class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0][0] == 1) return -1;
        // trick -> special case only one element [[0]]
        if (grid.length == 1 &&
            grid[0].length == 1 &&
            grid[0][0] == 0) return 1;

        int[][] dirs = new int[][]{
            {1, -1},
            {1, 0},
            {1, 1},
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, 1},
            {0, -1}
        };

        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {0, 0});
        grid[0][0] = 1;
        int step = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if (x >= 0 &&
                        x < grid.length &&
                        y >= 0 &&
                        y < grid[0].length &&
                        grid[x][y] == 0
                    ) {
                        if (x == grid.length - 1 && y == grid[0].length - 1) {
                            return step + 1;
                        }
                        grid[x][y] = 1;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
