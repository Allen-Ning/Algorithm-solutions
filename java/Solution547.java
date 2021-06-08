class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;

        boolean[] isVisited = new boolean[M.length];
        int counter = 0;
        for (int i = 0; i < M.length; i++) {
            if (!isVisited[i]) {
                helper(M, isVisited, i);
                counter++;
            }
        }
        return counter;
    }

    private void helper(int[][] M, boolean[] isVisited, int num) {
        for (int i = 0; i < M[num].length; i++) {
            if (!isVisited[i] && M[num][i] == 1) {
                isVisited[i]= true;
                helper(M, isVisited, i);
            }
        }
    }
}
