class Solution {
  public boolean isValidSudoku(char[][] board) {
    if (board == null) return false;

    for (int i = 0; i < board.length; i++) {
      HashSet<Character> rows = new HashSet();
      HashSet<Character> columns = new HashSet();
      HashSet<Character> cube = new HashSet();

      for (int j = 0 ; j < board[0].length; j++) {
        if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
        if (board[j][i] != '.' && !columns.add(board[j][i])) return false;

        int cubeX = (i / 3) * 3 + j / 3;
        int cubeY = (i % 3) * 3 + j % 3;
        if (board[cubeX][cubeY] != '.' && !cube.add(board[cubeX][cubeY])) return false;
      }
    }
    return true;
  }
}
