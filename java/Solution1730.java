class Solution {
    public int getFood(char[][] grid) {
        int[] startingPoint = findLocation(grid);
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[] {startingPoint[0], startingPoint[1]});

        int step = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (pq.size() > 0) {
            int size = pq.size();
            for (int z = 0; z < size; z++) {
                int[] location = pq.poll();

                for (int[] dir : dirs) {
                    int nextX = dir[0] + location[0];
                    int nextY = dir[1] + location[1];

                    if (nextX < 0 ||
                        nextX >= grid.length ||
                        nextY < 0 ||
                        nextY >= grid[0].length ||
                        grid[nextX][nextY] == 'X'
                    ) continue;

                    pq.offer(new int[]{nextX, nextY});
                    if (grid[nextX][nextY] == '#') return step + 1;
                    grid[nextX][nextY] = 'X';
                }
            }
            step++;
        }
        return -1;
    }

    private int[] findLocation(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '*') continue;
                grid[i][j] = 'X';
                return new int[]{i, j};
            }
        }
        return null;
    }
}