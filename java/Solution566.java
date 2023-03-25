class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // check if valid by the number of elements
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;
        if (m == r && n == c) return mat;

        int[][] results = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                results[index / c][index % c] = mat[i][j];
            }
        }
        return results;
    }
}