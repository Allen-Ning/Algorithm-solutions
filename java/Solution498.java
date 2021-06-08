class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};

        int row = matrix.length;
        int col = matrix[0].length;
        int[] results = new int[row * col];
        int i = 0;
        int j = 0;
        results[0] = matrix[i][j];
        int step = 1;
        while (step < row * col) {
            // going up
            if ((i + j) % 2 == 0) {
                // trick -> needs to check j == col - 1 first to avoid specail case
                // as when j == col - 1 it also meets i == 0
                // [ 1, 2, 3 ]
                // [ 4, 5, 6 ]
                // [ 7, 8, 9 ]
                if (j == col - 1) {
                    i++;
                } else if (i == 0) {
                    j++;    
                } else {
                    i--;
                    j++;
                }
            // going down
            } else {
                // trick -> needs to check i == row - 1 first to avoid specail case 
                // as when i == row - 1 it also meets j == 0
                // [ 1, 2 ]
                // [ 3, 4 ]
                if (i == row - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
            results[step] = matrix[i][j];
            step++;
        }
        return results;
    }
}
