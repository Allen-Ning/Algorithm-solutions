class Solution {
  public void setZeroes(int[][] matrix) {
    boolean rowZero = false;
    boolean columnZero = false;

    int rows = matrix.length;
    int columns = matrix[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) rowZero = true;
          if (j == 0) columnZero = true;
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < columns; j++) {
        if( matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (rowZero) {
      for (int j = 0; j < columns; j++) {
        matrix[0][j] = 0;
      }
    }

    if (columnZero) {
      for (int i = 0; i < rows; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
