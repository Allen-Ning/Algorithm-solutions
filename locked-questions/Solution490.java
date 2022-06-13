class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(start);
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = current[0] + dir[0];
                    int nextY = current[1] + dir[1];

                    // trick -> keep going if possible until the ball has to stop
                    while (nextX >= 0 &&
                           nextX < maze.length &&
                           nextY >= 0 &&
                           nextY < maze[0].length &&
                           maze[nextX][nextY] != 1
                          ) {
                        nextX += dir[0];
                        nextY += dir[1];
                    }

                    nextX -= dir[0];
                    nextY -= dir[1];
                    
                    if (isVisited[nextX][nextY]) continue;
                    isVisited[nextX][nextY] = true;
                    if (nextX == destination[0] && nextY == destination[1]) return true;
                    queue.offer(new int[] {nextX, nextY});
                }    
            }
        }
        return false;
    }
}