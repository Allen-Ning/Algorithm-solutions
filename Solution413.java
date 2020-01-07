class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int step = 0;
        int result = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i -1] == A[i - 1] - A[i - 2]) {
               step++;
               result += step;
            } else {
                step = 0;
            }
        }
        return result;
    }
}
