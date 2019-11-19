class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];

        for (int i = 0; i < S.length(); i++) {
          int index = S.charAt(i) - 'a';
          map[index] = Math.max(map[index], i);
        }

        List<Integer> results = new ArrayList();
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
          int index = S.charAt(i) - 'a';
          end = Math.max(end, map[index]);
          if (end == i) {
            results.add(end - start + 1);
            start = end + 1;
            end = start;
          }
        }
        return results;
    }
}
