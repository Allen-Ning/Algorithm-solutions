class Solution {
  public int maxProduct(String[] words) {
    if (words == null || words.length <= 1) return 0;
    int[] values = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        int value = word.charAt(j) - 'a';
        values[i] |= 1 << value;
      }
    }
    int result = 0;
    for (int i = 0; i < values.length; i++) {
      for (int j = i + 1; j < values.length; j++) {
        if ((values[i] & values[j]) == 0) {
          result = Math.max(result, words[i].length() * words[j].length());
        }
      }
    }
    return result;
  }
}
