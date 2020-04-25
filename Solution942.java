class Solution {
    public int[] diStringMatch(String S) {
        int start = 0;
        int end = S.length();
        int[] results = new int[S.length() + 1];
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'I') {
                results[index++] = start++;
            } else {
                results[index++] = end--;
            }
        }
        while (start <= end) {
            results[index++] = start++;
        }
        return results;
    }
}