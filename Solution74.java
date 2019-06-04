class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    int rows = matrix.length;
    int columns = matrix[0].length;
    int left = 0;
    int right = rows * columns;
    while(left < right) {
      int mid = left + (right - left) / 2;
      int x = mid / columns;
      int y = mid % columns;           
      if (matrix[x][y] == target) return true;
      if (matrix[x][y] > target) {
        right = mid ;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }
}
