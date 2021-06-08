class Solution {
    public int numSpecialEquivGroups(String[] A) {
    Set<String> set = new HashSet();

    for (String word : A) {
      int[] even = new int[26];
      int[] odd = new int[26];

      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int index = c - 'a';
        if (i % 2 == 0) {
          even[index] += 1;
        } else {
          odd[index] += 1;
        }
      }

      StringBuilder sb = new StringBuilder();
      append(sb, even);
      sb.append('-');
      append(sb, odd);

      set.add(sb.toString());
    }
    return set.size();
  }

  private void append(StringBuilder sb, int[] times) {
    for (int i = 0; i < times.length; i++) {
        for (int j = 0; j < times[i]; j++) {
          sb.append((char)(i + 'a'));
        }
      }
  }
}
