class Solution {
    public String minRemoveToMakeValid(String s) {
      if (s == null || s.length() == 0) return "";

      Stack<Integer> stack = new Stack();

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == '(') {
          stack.push(i);
        } else if (c == ')') {
          if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
            stack.pop();
          } else {
            stack.push(i);
          }
        }
      }

      StringBuilder sb = new StringBuilder(s);
      // trick -> we can use deleteCharAt due to we remove the char from larger index to smaller index
      while (!stack.isEmpty()) sb.deleteCharAt(stack.pop());

      return sb.toString();
    }
}
