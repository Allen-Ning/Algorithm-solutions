class Solution {
    //  input
    //  [2,3,4],
    //  [5,6,7],
    //  [8,9,10],
    //  [11,12,13],
    //  [14,15,16]

    //  output
    //  [4,4,5],
    //  [5,6,6],
    //  [8,9,9],
    //  [11,12,12],
    //  [13,13,14]
    public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int[][] results = new int[M.length][M[0].length];
        if (M.length == 0 || M[0].length == 0) return results;

        int[][] dirs = new int[][] {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                double total = 1;
                double value = M[i][j];
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 &&
                        y >= 0 &&
                        x < M.length &&
                        y < M[0].length
                       ) {
                        total++;
                        value += M[x][y];
                    }
                }
                results[i][j] = (int) Math.floor(value / total);
            }
        }
        return results;
    }
}
