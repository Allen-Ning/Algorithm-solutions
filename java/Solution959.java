class Solution {
    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length * 3;
        int col = grid[0].length() * 3;
        int[][] newGrid = new int[row][col];

        // trick -> we need to expand each cell to 3 * 3
        //          so that we can set \ or / to -1
        //          and then run dfs
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == '\\') {
                    newGrid[i * 3][j * 3] = -1;
                    newGrid[i* 3 + 1][j * 3 + 1] = -1;
                    newGrid[i* 3 + 2][j * 3 + 2] = -1;
                } else if (grid[i].charAt(j) == '/') {
                    newGrid[i * 3][j * 3 + 2] = -1;
                    newGrid[i* 3 + 1][j * 3 + 1] = -1;
                    newGrid[i* 3 + 2][j * 3] = -1;
                }
            }
        }
        int value = 1;
        int counter = 0;
        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[0].length; j++) {
                if (newGrid[i][j] == 0) {
                    dfs(newGrid, i, j, value++);
                    counter++;
                }

            }
        }
        return counter;
    }

    private void dfs(int[][] newGrid, int x, int y, int value) {
        Queue<int[]> queue = new LinkedList();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.offer(new int[] {x, y});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int newX = current[0] + dir[0];
                    int newY = current[1] + dir[1];
                    if (newX >= 0 &&
                        newX < newGrid.length &&
                        newY >= 0 &&
                        newY < newGrid[0].length &&
                        newGrid[newX][newY] == 0
                    ) {
                        newGrid[newX][newY] = value;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }
        }
    }
}
