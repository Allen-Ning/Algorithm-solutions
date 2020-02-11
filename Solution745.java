class WordFilter {

  // {apple
  // e{apple
  // le{apple
  // pple{apple
  // apple{appple
  TrieNode root;
  String[] words;
  public WordFilter(String[] words) {
    root = new TrieNode();
    this.words = words;

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = word.length(); j >= 0; j--) {
        // trick -> we need word.substring(j) to get some corner case like {apple
        String prefix = word.substring(j);
        // trick -> we have to seprate the prefix and postfix by special character such as { which is 27
        String str = prefix + (char)('z' + 1) + word;
        buildTrie(root, str, prefix, i);
      }
    }
  }

  private void buildTrie(TrieNode node, String str, String prefix, int weight) {
    TrieNode current = node;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (current.nodes[c - 'a'] == null) current.nodes[c - 'a'] = new TrieNode();
      current = current.nodes[c - 'a'];
      // trick -> after prefix, we get valid search result
      //          such as  // pple{apxxxx
      if (i >= prefix.length() - 1) {
          current.weight = Math.max(current.weight, weight);
      }
    }
  }

  public int f(String prefix, String suffix) {
    String str = suffix + (char)('z' + 1) + prefix;
    TrieNode current = root;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (current == null || current.nodes[c - 'a'] == null) {
          current = null;
          break;
      }
      current = current.nodes[c - 'a'];
    }

    if (current != null) return current.weight;
    return -1;
  }

  class TrieNode {
    TrieNode[] nodes;
    int weight;
    public TrieNode() {
      this.nodes = new TrieNode[27];
      this.weight = -1;
    }
  }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
