class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (!helper(board, i, j, 0, word)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, int index, String word) {
        if (index >= word.length()) return true;
        if (i < 0 ||
            j < 0 ||
            i >= board.length ||
            j >= board[0].length ||
            board[i][j] == '0' ||
            board[i][j] != word.charAt(index)
        ) return false;

        board[i][j] = '0';
        boolean result = helper(board, i + 1, j, index + 1, word) ||
            helper(board, i - 1, j, index + 1, word) ||
            helper(board, i, j + 1, index + 1, word) ||
            helper(board, i, j - 1, index + 1, word);

        // trick -> easy to forget reset the value
        board[i][j] = word.charAt(index);
        return result;
    }
}
