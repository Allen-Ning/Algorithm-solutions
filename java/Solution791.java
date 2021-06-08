class Solution791 {
    public String customSortString(String S, String T) {
    int[] letters = new int[26];
    for (char c: T.toCharArray()) {
      letters[c - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (char c: S.toCharArray()) {
      int index = c - 'a';
      while(letters[index]-- > 0) {
        sb.append(c);
      }
    }

    for (int i = 0; i < letters.length; i++) {
      while(letters[i]-- > 0) { sb.append((char)(i + 'a')); }
    }
    return sb.toString();
  }
}
