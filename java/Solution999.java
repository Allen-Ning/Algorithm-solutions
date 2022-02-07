class Solution {
    public int numRookCaptures(char[][] board) {
        int[] rook = findRook(board);

        if (rook == null) return -1;

        int startX = rook[0];
        int startY = rook[1];
        int result = 0;

        // trick - more functional way to implement
        //         go up, go down, go left, go right
        result += cal(board, startX, startY, 1, 0);
        result += cal(board, startX, startY, -1, 0);
        result += cal(board, startX, startY, 0, 1);
        result += cal(board, startX, startY, 0, -1);
        return result;
    }

    private int cal(char[][] board, int x, int y, int moveX, int moveY) {
        while (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
            if (board[x][y] == 'B') return 0;
            if (board[x][y] == 'p') return 1;
            x += moveX;
            y += moveY;
        }
        return 0;
    }

    private int[] findRook(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') return new int[] {i, j};
            }
        }
        return null;
    }
}