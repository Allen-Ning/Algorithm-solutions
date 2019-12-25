class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) return false;
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) isIncreasing = false;
            if (A[i - 1] < A[i]) isDecreasing = false;
        }
        return isIncreasing || isDecreasing;
    }
}
