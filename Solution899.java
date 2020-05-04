class Solution {
    public String orderlyQueue(String S, int K) {
        if (K >= 2) {
            char[] values = S.toCharArray();
            Arrays.sort(values);
            return new String(values);
        } else {
            String result = S;
            for (int i = 1; i < S.length(); i++) {
                String temp = S.substring(i) + S.substring(0, i);
                if (result.compareTo(temp) > 0) result = temp;
            }
            return result;
        }
    }
}
