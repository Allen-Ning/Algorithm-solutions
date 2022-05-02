class Solution {
  //  trick -> two binary searches will not work for example below:
  //  [1, 2, 3, 4, 5]
  //  [6, 7, 8, 9, 10]
  //  [11,12,13,14,15]
  //  [16,17,18,19,20]
  //  [21,22,23,24,25]
  //  19
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    int row = 0;
    int col = matrix[0].length - 1;

    while (row <= matrix.length - 1 && col >= 0) {
      if (target < matrix[row][col]) {
        col--;
      } else if (target == matrix[row][col]) {
        return true;
      } else if (target > matrix[row][col]) {
        row++;
      }
    }
    return false;
  }
}
