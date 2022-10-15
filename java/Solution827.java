class Solution {
    public int largestIsland(int[][] grid) {
        int counter = 2;
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) continue;
        
                int size = bfs(grid, i, j, counter);
                map.put(counter, size);
                max = Math.max(max, size);
                counter++;
            }
        }

        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) continue;

                int total = 1;
                boolean[] isVisited = new boolean[counter];
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
    
                    if (x < 0 || 
                        x >= grid.length || 
                        y < 0 || 
                        y >= grid[0].length ||
                        isVisited[grid[x][y]] || 
                        grid[x][y] < 2
                     ) continue;

                    total += map.getOrDefault(grid[x][y], 0);
                    isVisited[grid[x][y]] = true;
                }
                max = Math.max(max, total);
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int i, int j, int counter) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {i, j});
        grid[i][j] = counter;

        int result = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (queue.size() > 0) {
            int[] point = queue.poll();
            result++;

            for (int[] dir : dirs) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];

                if (x < 0 || 
                    x >= grid.length ||
                    y < 0 || 
                    y >= grid[0].length ||
                    grid[x][y] != 1) continue;

                    queue.offer(new int[] {x, y});
                    // trick -> this will prevent lots of duplicated grid[x][y] to be added in 
                    grid[x][y] = counter;
                }
        }
        return result;
    }
}