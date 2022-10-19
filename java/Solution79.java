class Solution {
  public boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
               if (helper(board, word, i, j, 0)) {
                   return true;
               }
          }
      }
      return false;
  }

  private boolean helper(char[][] board, String word, int x, int y, int index) {
      if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
      if (index >= word.length()) return false;
      if (board[x][y] != word.charAt(index)) return false;
      if (index == word.length() - 1 && board[x][y] == word.charAt(index)) return true;

      board[x][y] = '*';
      int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
      for (int[] dir : dirs) {
          int nextX = dir[0] + x;
          int nextY = dir[1] + y;

          if (helper(board, word, nextX, nextY, index + 1)) return true;
      }

      // trick -> easy to forget reset the value
      board[x][y] = word.charAt(index);
      return false;
  }
}