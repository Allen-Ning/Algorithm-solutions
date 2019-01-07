class Solution {
  public void rotate(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;

    for (int i = 0; i < rows/2; i++ ) {
      for (int j = 0; j < columns; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[rows - i - 1][j];
        matrix[rows - i - 1][j] = temp;
      }
    }

    for(int i = 0; i < rows; i ++) {
      for (int j = i; j < columns; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
}
