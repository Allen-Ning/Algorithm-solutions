class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        helper(board, x, y);
        return board;
    }
    
    private void helper(char[][] board, int x, int y) {
        
        if (x < 0 ||
            x >= board.length ||
            y < 0 ||
            y >= board[0].length ||
            board[x][y] != 'E') return;

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};
        int counter = count(board, x, y);
        if (counter == 0) {
            board[x][y] = 'B';
            for (int[] dir : dirs) helper(board, x + dir[0],  y + dir[1]);
        } else if (counter > 0) {
            board[x][y] = (char) (counter + '0');
        }
    }
    
    private int count(char[][] board, int x, int y) {
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};

        int counter = 0;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            
            if (newX >= 0 &&
                newX < board.length &&
                newY >= 0 &&
                newY < board[0].length &&
                board[newX][newY] == 'M') counter++;
        }
        return counter;
    }
}
