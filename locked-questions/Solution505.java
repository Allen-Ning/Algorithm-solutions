public class Solution {
    // trick -> not ac, migth need to double check
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList();
        boolean[][][][] isVisited = new boolean[maze.length][maze[0].length][3][3];
        int[][] dirs = new int[][]{ {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
        int offset = 1;
        for (int[] dir : dirs) {
            int nextX = start[0];
            int nextY = start[1];
            int dirX = dir[0];
            int dirY = dir[1];
            if (!canPlace(isVisited, maze, nextX, nextY, dirX, dirY)) continue;
            queue.offer(new int[] {nextX, nextY, dirX, dirY});
            isVisited[nextX][nextY][dirX + offset][dirY + offset] = true;
        }

        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int dirX = current[2];
                int dirY = current[3];

                int nextX = x + dirX;
                int nextY = y + dirY;
                if (nextX >= 0 &&
                    nextY >= 0 &&
                    nextX < maze.length &&
                    nextY < maze[0].length &&
                    isVisited[nextX][nextY][dirX + offset][dirY + offset]) continue;

                if (nextX < 0 ||
                    nextX >= maze.length ||
                    nextY < 0 ||
                    nextY >= maze[0].length ||
                    maze[nextX][nextY] == 1
                ) {
                    for (int[] dir : dirs) {
                        if (dir[0] == dirX && dir[1] == dirY) continue;
                        dirX = dir[0];
                        dirY = dir[1];
                        nextX = x + dirX;
                        nextY = y + dirY;

                        if (!canPlace(isVisited, maze, nextX, nextY, dirX, dirY)) continue;
                        queue.offer(new int[] {nextX, nextY, dirX, dirY});
                        isVisited[nextX][nextY][dirX + offset][dirY + offset] = true;
                        if (nextX == destination[0] && nextY == destination[1]) return step + 1;
                    }
                } else {
                    if (!canPlace(isVisited, maze, nextX, nextY, dirX, dirY)) continue;
                    queue.offer(new int[] {nextX, nextY, dirX, dirY});
                    isVisited[nextX][nextY][dirX + offset][dirY + offset] = true;
                    if (nextX == destination[0] && nextY == destination[1]) return step + 1;
                }
            }
            step++;
        }
        return -1;
    }

    private boolean canPlace(boolean[][][][] isVisited, int[][] maze, int x, int y, int dirX, int dirY) {
        int offset = 1;
        if (x < 0 ||
            y < 0 ||
            x >= maze.length ||
            y >= maze[0].length ||
            isVisited[x][y][dirX + offset][dirY + offset] ||
            maze[x][y] == 1
        ) return false;
        return true;
    }
}
