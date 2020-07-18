class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rowsCheck = new boolean[9][10];
        boolean[][] colsCheck = new boolean[9][10];
        boolean[][] boxesCheck = new boolean[9][10];

        preFill(board, rowsCheck, colsCheck, boxesCheck);
        boolean value = helper(board, rowsCheck, colsCheck, boxesCheck, 0, 0);
        System.out.println(value);
    }

    private boolean helper(char[][] board, boolean[][] rowsCheck, boolean[][] colsCheck, boolean[][] boxesCheck, int x, int y) {
        if (x == 9) return true;

        int index = getIndex(x, y);
        int nextX = (y == 8) ? x + 1 : x;
        int nextY = (y == 8) ? 0 : y + 1;

        if (board[x][y] != '.') return helper(board, rowsCheck, colsCheck, boxesCheck, nextX, nextY);

        for (int num = 1; num <= 9; num++) {
            if (rowsCheck[x][num] || colsCheck[y][num] || boxesCheck[index][num]) continue;
            rowsCheck[x][num] = true;
            colsCheck[y][num] = true;
            boxesCheck[index][num] = true;
            board[x][y] = (char) (num + '0');
            if (helper(board, rowsCheck, colsCheck, boxesCheck, nextX, nextY)) return true;

            board[x][y] = '.';
            rowsCheck[x][num] = false;
            colsCheck[y][num] = false;
            boxesCheck[index][num] = false;
        }
        return false;
    }

    private void preFill(char[][] board, boolean[][] rowsCheck, boolean[][] colsCheck, boolean[][] boxesCheck) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length;j ++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '0';
                rowsCheck[i][num] = true;
                colsCheck[j][num] = true;
                boxesCheck[getIndex(i, j)][num] = true;
            }
        }
    }

    // trick -> this is the most trick part to map (x, y) to box index
    //          (x / 3) * 3 + y / 3 ->  1 2 3
    //                                  4 5 6
    //                                  7 8 9
    //          (y / 3) * 3 + x / 3 ->  1 4 7
    //                                  2 5 8
    //                                  3 6 9
    private int getIndex(int x, int y) {
        return (x / 3) * 3 + y / 3;
    }
}
