class Solution {
    public String licenseKeyFormatting(String S, int K) {
        boolean isFristGroup = true;
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == '-') continue;
            if (counter == K) {
                sb.append('-');
                sb.append(c);
                counter = 1;
            } else if (counter < K) {
                sb.append(c);
                counter++;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
