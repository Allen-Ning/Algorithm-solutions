class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = -1;
        int j = matrix.length * matrix[0].length;
        while (i + 1 != j) {
            int mid = i + (j - i) / 2;

            // trick -> map 1 dimension index to 2 dimensions indexes
            int index = mid / matrix[0].length;
            int subIndex = mid % matrix[0].length;

            int value = matrix[index][subIndex];
            if (value > target) {
               j = mid;
            } else if (value == target) {
               return true;
            } else {
               i = mid;
            }
        }
        return false;
    }
}