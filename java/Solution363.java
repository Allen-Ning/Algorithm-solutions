class Solution {
    // col^2 * row row^2 * col
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] preSum = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < preSum.length; i++) {
            for (int j = 1; j < preSum[0].length; j++) {
                preSum[i][j] = preSum[i][j - 1] + matrix[i][j - 1];
            }
        }

        long result = Integer.MIN_VALUE;
        for (int i = 0; i < preSum[0].length; i++) {
            for (int j = i + 1; j < preSum[0].length; j++) {
                TreeSet<Long> set = new TreeSet();
                set.add((long) 0);
                long total = 0;
                for (int z = 0; z < preSum.length; z++) {
                    int value = preSum[z][j] - preSum[z][i];
                    total += value;
                    long searchedValue = total - k;
                    Long ceilingValue = set.ceiling(searchedValue);
                    if (ceilingValue != null) {
                        long current = total - ceilingValue;
                        if (current == k) return (int) current;
                        // trick -> current must be less than k
                        result = Math.max(current, result);
                    }
                    set.add(total);
                }
            }
        }
        return result == Integer.MIN_VALUE ? -1 : (int) result;
    }
}
