class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                queue.offer(new int[] {i, j});
                grid[i][j] = -1;
            }
        }

        // trick -> handle special case
        //         [[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]]
        if (queue.size() == grid.length * grid[0].length) return -1;

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x < 0 ||
                        x >= grid.length ||
                        y < 0 ||
                        y >= grid[0].length ||
                        grid[x][y] != 0
                    ) continue;
                    queue.offer(new int[] {x, y});
                    grid[x][y] = -1;
                }
            }
            step++;
        }
        return step - 1;
    }
}