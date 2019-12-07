// trick case:
// ["StreamChecker","query","query","query"]
// [[["ab","ba","aaab","abab","baa"]],["a"],["b"],["a"]]
// result:
// [null,false,true,true]

class StreamChecker {

    class TrieNode {
      char c;
      TrieNode[] list;
      boolean isWord;

      public TrieNode(char c, boolean isWord) {
        this.c = c;
        this.isWord = isWord;
        this.list = new TrieNode[128];
      }
    }

    TrieNode root = new TrieNode(' ', false);
    List<Character> typedLetters = new ArrayList();

    public StreamChecker(String[] words) {
      TrieNode node = root;
      for (String word : words) {
        node = root;
        // trick -> we need to add nodes in words' reverse order
        for (int i = word.length() - 1; i >= 0; i--) {
          char c = word.charAt(i);
          int index = c - 'a';
          if (node.list[index] == null) {
            TrieNode newNode = new TrieNode(c, false);
            node.list[index] = newNode;
          }
          node = node.list[index];
          boolean isWord = (i == 0 ? true : false);
          if (!node.isWord) node.isWord = isWord;
        }
      }
    }

    public boolean query(char letter) {
      char c = letter;
      int index = c - 'a';
      int last = typedLetters.size() - 1;
      TrieNode node = root.list[index];
      while (node != null) {
        if (node.isWord) {
          // trick -> we always need to insert the last char to history typed chars
          typedLetters.add(letter);
          return true;
        }

        if (last < 0) break;
        c = typedLetters.get(last);
        index = c - 'a';
        node = node.list[index];
        last--;
      }
      typedLetters.add(letter);
      return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
