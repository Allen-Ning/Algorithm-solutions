class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if (A.length <= 1) return A;
        int even = 0;
        int odd = 1;
        while (even < A.length && odd < A.length) {
            while (even < A.length && A[even] % 2 == 0) even += 2;

            while (odd < A.length && A[odd] % 2 != 0) odd += 2;

            // trick -> if one pointer is out of bound, which means we have done the swop
            if (even > A.length || odd > A.length) break;
            swop(A, even, odd);
        }
        return A;
    }

    private void swop(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}
