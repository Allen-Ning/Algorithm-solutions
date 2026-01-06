class Solution {
  public int calculate(String s) {
    // trick -> trim spaces to avoid edge case "1 + 2 " to make sure the last
    // character always being evaluated
    s = s.trim();
    // trick -> sign is actually prev-sign
    char evalSign = '+';
    int num = 0;
    int i = 0;
    Stack<Integer> stack = new Stack();
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == ' ') {
        i++;
        continue;
      }

      if (c >= '0' && c <= '9')
        num = num * 10 + c - '0';
      // trick -> not do forget to trigger this when string reaching the end
      if ((c < '0' || c > '9') || i == s.length() - 1) {
        // operator
        if (evalSign == '+') {
          stack.push(num);
        } else if (evalSign == '-') {
          stack.push(num * -1);
        } else if (evalSign == '*') {
          stack.push(stack.pop() * num);
        } else if (evalSign == '/') {
          stack.push(stack.pop() / num);
        }
        evalSign = c;
        num = 0;
      }
      i++;
    }

    long result = 0;
    while (stack.size() > 0) {
      result += stack.pop();
    }
    return (int) result;
  }
}