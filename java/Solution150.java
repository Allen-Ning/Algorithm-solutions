class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null) return 0;

        Stack<Integer> stack = new Stack();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer value = stack.pop();
                Integer value2 = stack.pop();
                stack.push(value + value2);
            } else if (token.equals("-")) {
                Integer value = stack.pop();
                Integer value2 = stack.pop();
                stack.push(value2 - value);
            } else if (token.equals("*")) {
                Integer value = stack.pop();
                Integer value2 = stack.pop();
                stack.push(value2 * value);
            } else if (token.equals("/")) {
                Integer value = stack.pop();
                Integer value2 = stack.pop();
                stack.push(value2 / value);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}