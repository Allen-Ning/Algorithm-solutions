public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                // trick -> adding all gates to bfs queue rather than empty room
                if (rooms[i][j] == 0) queue.offer(new int[] {i, j});
            }
        }

        int step = 0;
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = current[0] + dir[0];
                    int nextY = current[1] + dir[1];

                    if (nextX < 0 ||
                        nextX >= rooms.length ||
                        nextY < 0 ||
                        nextY >= rooms[0].length ||
                        rooms[nextX][nextY] < 2147483647
                    )  continue;
                    queue.offer(new int[] { nextX, nextY });
                    rooms[nextX][nextY] = step + 1;
                }
            }
            step++;
        }
    }
}