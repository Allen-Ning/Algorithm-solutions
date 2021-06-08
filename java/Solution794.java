class Solution {
    public boolean validTicTacToe(String[] board) {
        int numX = 0;
        int numO = 0;
        int leftCross = 0;
        int rightCross = 0;
        int resultX = 0;
        int resultO = 0;

        // row check -> board[i][j]
        // column check -> board[j][i]
        // left cross check -> board[i][j] (when i == j)
        // right cross check -> board[i][j] (when i + j == board.length - 1)
        // [0][0] [0][1] [0][2]
        // [1][0] [1][1] [1][2]
        // [2][0] [2][1] [2][2]
        for (int i = 0; i < board.length; i++) {
            int horizontalSum = 0;
            int verticalSum = 0;
            for (int j = 0; j < board[0].length(); j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    numX++;
                    horizontalSum++;
                    if (i == j) leftCross++;
                    if (i + j == board.length - 1) rightCross++;
                } else if (c == 'O') {
                    numO++;
                    horizontalSum--;
                    if (i == j) leftCross--;
                    if (i + j == board.length - 1) rightCross--;
                }

                c = board[j].charAt(i);
                if (c == 'X') {
                    verticalSum++;
                } else if (c == 'O') {
                    verticalSum--;
                }
            }

            if (horizontalSum == 3 ||
                verticalSum == 3 ||
                leftCross == 3 ||
                rightCross == 3
               ) resultX++;

             if (horizontalSum == -3 ||
                verticalSum == -3 ||
                leftCross == -3 ||
                rightCross == -3
               ) resultO++;
        }

        //  trick -> the num of X must be more than or equal to the num of O
        //           the num of X cannot be more than 2 when compared with the num of O
        if (numX < numO || numX - numO > 1) return false;
        // trick -> X and O cannot win at the same time
        if (resultX >= 1 && resultO >= 1) return false;
        // trick -> when X wins, the num of X must be more than the num of O
        if (resultX >= 1 && numX == numO) return false;
        // trick -> when O wins, the nums of X must be same as the num of O
        if (resultO >= 1 && numX > numO) return false;
        return true;
    }
}
