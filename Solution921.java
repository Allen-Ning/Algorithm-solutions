class Solution {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;

        Stack<Character> stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }
}
