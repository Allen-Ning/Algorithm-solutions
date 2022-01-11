class Solution {
    public int getFood(char[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int[] startPoint = findStartPoint(grid);
        Queue<int[]> queue = new LinkedList();

        queue.offer(startPoint);
        isVisited[startPoint[0]][startPoint[1]] = true;
        int step = 0;
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x < 0 ||
                        x >= grid.length ||
                        y < 0 ||
                        y >= grid[0].length ||
                        isVisited[x][y] ||
                        grid[x][y] == '*' ||
                        grid[x][y] == 'X'
                    ) {
                        continue;
                    }

                    if (grid[x][y] == '#') return step + 1;

                    queue.offer(new int[] {x, y});
                    isVisited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }

    private int[] findStartPoint(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '*') continue;
                return new int[]{i, j};
            }
        }
        return null;
    }
}
