class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, cal(cache, matrix, i, j, Integer.MIN_VALUE));
             }
        }

        return max;
    }

    private int cal(int[][] cache, int[][] matrix, int x, int y, int prevValue) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return 0;
        if (matrix[x][y] <= prevValue) return 0;
        if (cache[x][y] != 0) return cache[x][y];
        int max = 0;
        max = Math.max(max, cal(cache, matrix, x, y - 1, matrix[x][y]));
        max = Math.max(max, cal(cache, matrix, x, y + 1, matrix[x][y]));
        max = Math.max(max, cal(cache, matrix, x + 1, y, matrix[x][y]));
        max = Math.max(max, cal(cache, matrix, x - 1, y, matrix[x][y]));
        cache[x][y] = max + 1;
        return cache[x][y];
    }
}
