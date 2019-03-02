class NumMatrix {
    private int[][] sums;
    public NumMatrix(int[][] matrix) {
      if (matrix == null ||
          matrix.length == 0 ||
           matrix[0].length == 0
         ) return;
      int rows = matrix.length;
      int columns = matrix[0].length;
      sums = new int[rows + 1][columns + 1];

      for (int i = 1; i < rows + 1; i++) {
        for (int j = 1; j < columns + 1; j++) {
          sums[i][j] = sums[i][j - 1] + sums[i - 1][j] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int maxRow = Math.max(row1, row2);
      int minRow = Math.min(row1, row2);
      int maxCol = Math.max(col1, col2);
      int minCol = Math.min(col1, col2);

      return sums[maxRow + 1][maxCol + 1] - sums[minRow][maxCol + 1] - sums[maxRow + 1][minCol] + sums[minRow][minCol];
    }
}

