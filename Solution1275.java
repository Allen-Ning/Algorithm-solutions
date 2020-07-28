class Solution {
    public String tictactoe(int[][] moves) {
        boolean isX = true;
        int left = 0;
        int right = 0;
        int[] rows = new int[3];
        int[] cols = new int[3];
        for (int[] move : moves) {
            int x = move[0];
            int y = move[1];

            if (isX) {
                rows[x]++;
                cols[y]++;
            } else {
                rows[x]--;
                cols[y]--;
            }

            if (rows[x] == 3 || cols[y] == 3) return "A";
            if (rows[x] == -3 || cols[y] == -3) return "B";

            if (x == y) {
                if (isX) {
                    left++;
                } else {
                    left--;
                }
            }

            if (x + y == 2) {
                if (isX) {
                    right++;
                } else {
                    right--;
                }
            }
            isX = !isX;
        }
        if (left == 3 || right == 3) return "A";
        if (left == -3 || right == -3) return "B";
        if (moves.length < 9) return "Pending";
        if (moves.length == 9) return "Draw";
        return "error";
    }
}
