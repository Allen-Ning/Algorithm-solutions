class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    String value = bfs(grid, i, j);
                    set.add(value);
                }
            }
        }
        return set.size();
    }

    private String bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {i, j});
        StringBuilder sb = new StringBuilder();
        sb.append("O");
        grid[i][j] = 2;

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] identifiers = new String[] {"U", "D", "L", "R"};
        while (queue.size() > 0) {
            int size = queue.size();

            for (int w = 0; w < size; w++) {
                int[] current = queue.poll();
                for (int z = 0; z < dirs.length; z++) {
                    int[] dir = dirs[z];
                    int nextX = current[0] + dir[0];
                    int nextY = current[1] + dir[1];

                    if (nextX < 0 ||
                        nextX >= grid.length ||
                        nextY < 0 ||
                        nextY >= grid[0].length ||
                        grid[nextX][nextY] != 1
                    ) continue;

                    grid[nextX][nextY] = 2;
                    queue.offer(new int[] {nextX, nextY});
                    sb.append(identifiers[z]);
                }
                // trick ->  here is to avoid corner case as below:
                             // [1,1,0],
                             // [0,1,1],
                             // [0,0,0]
                             // [1,1,1]
                             // [0,1,0]]
                sb.append("|");
            }
        }
        return sb.toString();
    }
}