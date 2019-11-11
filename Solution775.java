class Solution {
    // trick -> global inversion includes local inversion
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length == 0) return false;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(A[i], max);
            if (max > A[i + 2]) return false;
        }
        return true;
    }
}
