class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // trick -> we need to add 0 based-index for matrix[0].length + 1 for easy calculating
        int[][] preSum = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < preSum.length; i++) {
            for (int j = 1; j < preSum[0].length; j++) {
                preSum[i][j] = preSum[i][j - 1] + matrix[i][j - 1]; 
            }
        }

        int result = 0;
        // trick -> 
        //     k  0  x x x i x x x j
        //     |  1  x x x x x x x x
        //     |  2  x x x x x x x x
        //     V  3  x x x x x x x x
        //        4  x x x x x x x x
        // total = matrix[0][j] - matrix[0][i] +
        //         matrix[1][j] - matrix[1][i] +
        //         matrix[2][j] - matrix[2][i] +
        //         matrix[3][j] - matrix[3][i] +
        //         matrix[4][j] - matrix[4][i] +
        //
        // total = SumK(matrix[k][j] - matrix[k][i]) when k from 0 -> 4
        for (int i = 0; i < preSum[0].length; i++) {
            for (int j = i + 1; j < preSum[0].length; j++) {
                HashMap<Integer, Integer> map = new HashMap();
                int total = 0;
                map.put(0, 1);

                for (int k = 0; k < preSum.length; k++) {
                    int value = preSum[k][j] - preSum[k][i];
                    total += value;
                    int searchValue = total - target;
                    // trick -> this is like twoSum searching for the exisiting value
                    result += map.getOrDefault(searchValue, 0);
                    map.put(total, map.getOrDefault(total, 0) + 1);
                }
            }
        }
        return result;
    }
}
