class TicTacToe {
    int[] rows;
    int[] columns;
    int leftDiagonal;
    int antiDiagonal;
    int n;

    public TicTacToe(int n) {
        this.rows = new int[n];
        this.columns = new int[n];
        this.leftDiagonal = 0;
        this.antiDiagonal = 0;
        this.n = n;
    }

    public int move(int row, int col, int player) {
        int addedValue = player == 1 ? 1 : -1;

        rows[row] += addedValue;
        columns[col] += addedValue;
        if (row == col) leftDiagonal += addedValue;
        // trick -> this is the trick how to calculate antiDiagonal
        if (row + col == n - 1) antiDiagonal += addedValue;

        if (rows[row] == n || columns[col] == n || leftDiagonal == n || antiDiagonal == n) return 1;
        if (rows[row] == -n || columns[col] == -n || leftDiagonal == -n || antiDiagonal == -n) return 2;

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */