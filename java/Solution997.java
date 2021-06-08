class Solution {
    // trick -> assumption there is no duplication records in trust array
    public int findJudge(int N, int[][] trust) {
        int[] inBound = new int[N + 1];
        int[] outBound = new int[N + 1];

        for (int[] pair : trust) {
            inBound[pair[1]] += 1;
            outBound[pair[0]] += 1;
        }

        int counter = 0;
        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (inBound[i] == N - 1 && outBound[i] == 0) {
                result = i;
                counter++;
            }
        }
        return counter == 1 ? result : -1;
    }
}
