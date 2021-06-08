class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int result = Integer.MAX_VALUE;
        // trick -> the selected value can only be A[i], B[i] such as A[0], B[0]
        //          e.g. A = [2,1,2,4,2,2], 
        //               B = [5,2,6,2,3,2]
        //          the selected value will be 2 or 5
        result = Math.min(result, check(A, B, A[0]));
        result = Math.min(result, check(A, B, B[0]));
        result = Math.min(result, check(B, A, B[0]));
        result = Math.min(result, check(B, A, A[0]));
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int check(int[] A, int[] B, int value) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == value) {
                continue;
            } else if (B[i] == value) {
                result++;
                continue;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return result;
    }
}
