class Solution {

    public int[] prevPermOpt1(int[] A) {
        if (A == null || A.length == 0) return A;

        // find left;
        int left = A.length - 2;
        while (left >= 0 && A[left] <= A[left + 1]) left--;

        if (left == -1) return A;

        int right = A.length - 1;
        while (right >= 0 && A[right] >= A[left]) right--;
        while (right >= 1 && A[right] == A[right - 1]) right--;

        int temp = A[right];
        A[right] = A[left];
        A[left] = temp;
        return A;
    }

    // trick -> basic idea double loop
    // 1. find the most right number [x x x x x 8 4 5 6 9] like 8
    // 2. find the highest value less than the most right number to swop like 6
    // 3. swop them to [x x x x x 6 4 5 8 9]
    public int[] prevPermOpt1_naive_solution(int [] A) {
        if (A == null || A.length == 0) return A;
        int gap = Integer.MAX_VALUE;
        for (int i = A.length - 2; i >= 0; i--) {
            int p1 = i;
            int p2 = -1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i] && A[i] - A[j] < gap) {
                    gap = A[i] - A[j];
                    p2 = j;
                }
            }
            if (p2 != -1) {
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                break;
            }
        }
        return A;
    }
}