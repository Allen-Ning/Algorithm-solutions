class TicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int addedValue = (player == 1 ? 1 : -1);
        this.rows[row] += addedValue;
        this.cols[col] += addedValue;
        if (row == col) diagonal += addedValue;
        if (row + col == n - 1) antiDiagonal += addedValue;

        if (rows[row] == n || 
            cols[col] == n ||
            diagonal == n ||
            antiDiagonal == n
        ) {
            return 1;
        } else if (rows[row] == -1 * n ||
                   cols[col] == -1 * n ||
                   diagonal == -1 * n ||
                   antiDiagonal == -1 * n
        ) {
            return 2;
        } else {
            return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */