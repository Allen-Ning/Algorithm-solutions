class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int liveNeighbours = livesNeighbour(board, row, column, i, j);
                boolean isLive = ((board[i][j] & 1) == 1);
                if (isLive) {
                    if (liveNeighbours == 2 || liveNeighbours == 3) {
                        board[i][j] = 3;   
                    }
                } else {
                    if (liveNeighbours == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int livesNeighbour(int[][] board, int row, int column, int i, int j) {  
        int lives = 0;
        for (int indexRow = Math.max(0, i - 1); indexRow <= Math.min(i + 1, row - 1); indexRow++) {
            for (int indexCol = Math.max(0, j - 1); indexCol <= Math.min(j + 1, column - 1); indexCol++) {
                if ((board[indexRow][indexCol] & 1) == 1) {
                    lives += 1;
                }
            } 
        }
        if ((board[i][j] & 1) == 1) lives--;
        return lives;
    }
}
