class Solution {
    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swop = new int[N];
        int[] notSwop = new int[N];
        Arrays.fill(swop, A.length);
        Arrays.fill(notSwop, A.length);

        swop[0] = 1;
        notSwop[0] = 0;
        // trick -> It is guaranteed that the given input always makes it possible to both of array in increasing order
        for (int i = 1; i < N; i++) {
            // trick -> scenario 1 to possibly make both of array increasing from 0 index to i index
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                swop[i] = swop[i - 1] + 1; // the current i swop, and i - 1 swop 
                notSwop[i] = notSwop[i - 1]; // the current i not swop, and i - 1 not swop
            }

            // trick -> scenario 2 to possibly make both of array increasing
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                swop[i] = Math.min(swop[i], notSwop[i - 1] + 1); // the current i swop, and i - 1 not swop 
                notSwop[i] = Math.min(notSwop[i], swop[i - 1]); // the current i not swop, and i - 1 swop 
            }

        }
        return Math.min(swop[N - 1], notSwop[N - 1]);
    }
}
