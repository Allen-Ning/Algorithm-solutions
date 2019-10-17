class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> results = new HashSet();
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        TrieNode root = buildTrie(words, board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                isInTrie(root, board, isVisited, i, j, results, "");
            }
        }

        List<String> list = new ArrayList();
        for (String str : results) {
            list.add(str);
        }
        return list;
    }

    private void isInTrie(TrieNode parent, char[][] board, boolean[][] isVisited, int i, int j, Set<String> results, String str) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j]) {
            return;
        }

        TrieNode node = parent.children[board[i][j] - 'a'];
        if (node == null) return;
        isVisited[i][j] = true;

        StringBuilder sb = new StringBuilder(str);
        sb.append(board[i][j]);
        String current = sb.toString();
        if (node != null && node.isWord) {
            results.add(current);
            // trick -> do not do early return
        }

        isInTrie(node, board, isVisited, i + 1, j, results, current);
        isInTrie(node, board, isVisited, i, j + 1, results, current);
        isInTrie(node, board, isVisited, i - 1, j, results, current);
        isInTrie(node, board, isVisited, i, j - 1, results, current);
        isVisited[i][j] = false;
    }

    private TrieNode buildTrie(String[] words, char[][] board) {
        TrieNode root = new TrieNode();
        TrieNode parent = null;
        for (int i = 0; i < words.length; i++) {
            parent = root;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                TrieNode node = null;
                // trick -> make sure use the exising node
                if (parent.children[c - 'a'] == null) {
                    node = new TrieNode();
                    parent.children[c - 'a'] = node;
                } else {
                    node = parent.children[c - 'a'];
                }
                parent = node;
            }
            parent.isWord = true;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
