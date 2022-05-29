class Solution {
    // trick -> 00 means next is dead and current is dead 
    //          01 means next is dead and current is live
    //          10 means next is live and current is dead
    //          11 means next is live and current is live
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                change(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                getStatus(board, i, j);
            }
        }
    }

    private void change(int[][] board, int i, int j) {
        int liveNeighbours = 0;

        int[][] dirs = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || (board[x][y] & 1) == 0) continue;
            liveNeighbours++;
        }

        boolean isLive = (board[i][j] & 1) == 1;
        if (isLive && (liveNeighbours == 2 || liveNeighbours == 3)) {
            board[i][j] = board[i][j] | 2;
        } else if (!isLive && liveNeighbours == 3) {
            board[i][j] = board[i][j] | 2;
        }
    }

    private void getStatus(int[][] board, int i, int j) {
        board[i][j] = board[i][j] >> 1;
    }
}