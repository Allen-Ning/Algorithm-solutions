class Solution {

    char[][] board = null;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        this.board = board;

        // left 
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'L';
                check(i, 1);
            }
        }

        // right 
        int lastColumn = board[0].length - 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][lastColumn] == 'O') {
                board[i][lastColumn] = 'L';
                check(i, lastColumn - 1);
            }
        }

        // top 
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'L';
                check(1, j);
            }
        }

        // bottom
        int lastRow = board.length - 1;
        for (int j = 0; j < board[0].length; j++) {
            if (board[lastRow][j] == 'O') {
                board[lastRow][j] = 'L';
                check(lastRow - 1, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') { 
                    board[i][j] = 'X';
                } else if (board[i][j] == 'L') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void check(int row, int column) {
        if (row < 0 || row > board.length - 1 || column < 0 || column > board[0].length - 1) return;
        if (board[row][column] == 'X' || board[row][column] == 'L') return;

        if (board[row][column] == 'O') {
            board[row][column] = 'L';
            check(row + 1, column);
            check(row - 1, column);
            check(row, column + 1);
            check(row, column -1);
        }

    }
}
