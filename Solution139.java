class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    // how many character in the state array
    // 0 means empty
    // 1 means only a character

    boolean[] characters = new boolean[wordDict.length + 1];
    characters[0] = true;

    for (int i  = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (characters[j] && wordDict.contains(s.substring(j, i))) {
          characters[i] = true;
          break;
        }
      }
    }
    return characters[s.length()];
  }
}
