class Solution {
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) return "";

        int counter = 0;
        StringBuilder sb = new StringBuilder();
        // trick -> it's basically a simplifier version of stack
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(' && counter++ > 0) {
                sb.append(c);
            } else if (c == ')' && --counter > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
