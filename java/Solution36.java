class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grids = new boolean[9][9]; 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;

                // trick -> easy to calcute wrong
                int gridIndex = (i / 3) * 3 + j / 3;
                int valueIndex = board[i][j] - '1';
                
                if (rows[i][valueIndex]) return false;
                if (cols[j][valueIndex]) return false;
                if (grids[gridIndex][valueIndex]) return false;

                rows[i][valueIndex] = true;
                cols[j][valueIndex] = true;
                grids[gridIndex][valueIndex] = true;
            }
        }
        return true;
    }
}
