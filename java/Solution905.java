class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) return new int[0];

        int slow = -1;
        int fast = 0;
        while (fast < A.length && slow < A.length) {
            if (A[fast] % 2 == 0) {
                slow++;
                int temp = A[fast];
                A[fast] = A[slow];
                A[slow] = temp;
            }
            fast++;
        }
        return A;
    }
}
