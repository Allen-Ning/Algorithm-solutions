class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> s = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            int addedValue = -1;
            int value1 = -1;
            int value2 = -1;
            if (token.equals("+")) {
                value1 = Integer.valueOf(s.pop());
                value2 = Integer.valueOf(s.pop());
                addedValue = value1 + value2;
            } else if (token.equals("-")) {
                value1 = Integer.valueOf(s.pop());
                value2 = Integer.valueOf(s.pop());
                addedValue = value2 - value1;
            } else if (token.equals("*")) {
                value1 = Integer.valueOf(s.pop());
                value2 = Integer.valueOf(s.pop());
                addedValue = value1 * value2;
            } else if (token.equals("/")) {
                value1 = Integer.valueOf(s.pop());
                value2 = Integer.valueOf(s.pop());
                addedValue = value2 / value1;
            } else {
                addedValue = Integer.valueOf(token);
            }
            s.push(addedValue);
            
        }
        return s.pop();
    }

}
