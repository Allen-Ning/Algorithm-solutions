class Solution {
  private String word;
  private char[][] board;

  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int columns = board[0].length;
    
    this.board = board;
    this.word = word;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        boolean[][] visited = new boolean[rows][columns];
        if (search(0, i, j, visited)) return true;
      }
    }
    return false;
  }

  private boolean search(int index, int i, int j, boolean[][] visited) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
    if (visited[i][j]) return false;
    if (!(this.board[i][j] == this.word.charAt(index))) return false;
    if (index == this.word.length() - 1) return true;
    visited[i][j] = true;
    boolean result = search(index + 1, i, j - 1, visited) || 
           search(index + 1, i, j + 1, visited) || 
           search(index + 1, i + 1, j, visited) || 
           search(index + 1, i - 1, j, visited);
    if(!result) visited[i][j] = false;
    return result;
  }
}
