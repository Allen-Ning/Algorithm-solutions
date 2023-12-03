class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int counter = 0;
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int value = grid[i][j];
                if (value == 2) queue.offer(new int[] {i, j});
                if (value == 1) counter++;
            }
        }

        if (counter == 0) return 0;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : dirs) {
                    int nextX = point[0] + dir[0];
                    int nextY = point[1] + dir[1];
                    if (nextX < 0 ||
                        nextX >= grid.length ||
                        nextY < 0 ||
                        nextY >= grid[0].length ||
                        grid[nextX][nextY] != 1
                    ) continue;

                    queue.offer(new int[] {nextX, nextY});
                    counter--;
                    grid[nextX][nextY] = 2;
                }
            }
            step++;
        }
        // trick -> make to make a mistake about the final result returned is step - 1
        return counter == 0 ? step - 1 : -1;
    }
}