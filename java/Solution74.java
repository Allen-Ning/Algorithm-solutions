class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = -1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols;

        while (start + 1 != end) {
            int mid = start + (end - start) / 2;

            // trick -> map 1 dimension index to 2 dimensions indexes
            if (matrix[mid / cols][mid % cols] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start >= 0 && matrix[start / cols][start % cols] == target;
    }
}