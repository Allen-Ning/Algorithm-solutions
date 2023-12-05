class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] results = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) continue;

                // trick -> to use bfs reversed way
                queue.add(new int[]{i, j});
            }
        }

        int step = 1;
        int[][] dirs = new int[][] {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll()

                for (int[] dir : dirs) {
                    int newX = point[0] + dir[0];
                    int newY = point[1] + dir[1];

                    if (newX < 0 ||
                        newX >= mat.length ||
                        newY < 0 ||
                        newY >= mat[0].length ||
                        mat[newX][newY] == 0
                    ) continue;

                    queue.offer(new int[]{newX, newY});
                    mat[newX][newY] = 0;
                    results[newX][newY] = step;
                }
            }
            step++;
        }
        return results;
    }
}