class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack();
        int counter = 0;
        // trick -> the most left index
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if (c == ')') {
                int stackTop = stack.pop();
                 // trick -> the most left index replace -1 with the index of ')'
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // trick -> find the most-left element before pop();
                    counter = Math.max(counter, i -  stack.peek());
                }
            }
        }
        return counter;
    }
}
