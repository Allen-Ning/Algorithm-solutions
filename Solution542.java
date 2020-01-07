class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] results = new int[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // trick -> to use bfs reversed way
                if (matrix[i][j] == 0) queue.offer(new int[] {i, j});
            }
        }

        helper(queue, matrix, results);
        return results;
    }

    private void helper(Queue<int[]> queue, int[][] matrix, int[][] results) {
        int[][] dirs = new int[][] {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int newX = current[0] + dir[0];
                    int newY = current[1] + dir[1];
                    if (newX >= 0 &&
                        newX < matrix.length &&
                        newY >= 0 &&
                        newY < matrix[0].length &&
                        matrix[newX][newY] == 1
                        ) {
                        matrix[newX][newY] = 0;
                        queue.offer(new int[] {newX, newY});
                        results[newX][newY] = step + 1;
                    }
                }
            }
            step++;
        }
    }

}
