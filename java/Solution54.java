class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int total = matrix.length * matrix[0].length;
        // right, down, left, up
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        helper(result, matrix, dirs, total, 0, 0, 0);
        return result;
    }

    // trick -> special case
    //          e.g.
    //                 [1, 2, 3, 4]
    //                 [5, 6, 7, 8]
    //                 [9, 10,11,12]
    //                 [13,14,15,16]
    //
    //          result [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    private void helper(List<Integer> result, int[][] matrix, int[][] dirs, int total, int i , int j, int baseIndex) {
        if (i < 0 || i >= matrix.length) return;
        if (j < 0 || j >= matrix[0].length) return;
        if (matrix[i][j] > 100) return;

        result.add(matrix[i][j]);
        matrix[i][j] = 101;

        // trick -> keep track the current direction if possible
        for (int z = 0; z < dirs.length; z++) {
            int index = (baseIndex + z) % dirs.length;
            helper(result, matrix, dirs, total, i + dirs[index][0], j + dirs[index][1], index);
        }
    }
}