class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList();

        helper(results, matrix, 0, 0, 0);
        return results;
    }

    private void helper(List<Integer> results, int[][] matrix, int x, int y, int direction) {
        if (x < 0 ||
            x >= matrix.length ||
            y < 0 ||
            y >= matrix[0].length ||
            matrix[x][y] < -100
           ) return;

        results.add(matrix[x][y]);
        matrix[x][y] = -200;

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // trick -> keep the current direction if possible
        helper(results, matrix, x + directions[direction][0], y + directions[direction][1], direction);

        // trick -> if not cannot keep the current direction,
        //          will try other direction based on the priority (right, down, left, up)
        for (int i = 0; i < directions.length; i++) {
            if (i == direction) continue;

            int nextX = x + directions[i][0];
            int nextY = y + directions[i][1];
            helper(results, matrix, nextX, nextY, i);
        }
    }
}