public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] results = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                // trick -> this is good for sparse matrix to skip the loop for t
                if (A[i][j] == 0) continue;
                for (int t = 0; t < B[0].length; t++) {
                    results[i][t] += A[i][j] * B[j][t];
                }
            }
        }
        return results;
    }

    public int[][] multiply2(int[][] A, int[][] B) {
        for (int t = 0; t < B[0].length; t++) {
            for (int i = 0; i < A.length; i++) {
                int result = 0;
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 0 || B[j][t] == 0) continue;
                    result += A[i][j] * B[j][t];
                }
                results[i][t] = result;
            }
        }
        return results;
    }
}