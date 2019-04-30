class Solution {
  public int calculate(String s) {
    char sign = '+';
    int num = 0;
    Stack<Integer> stack = new Stack();
    String modifiedS = s.trim();
    for (int i = 0; i < modifiedS.length(); i++) {
      char c = modifiedS.charAt(i);
      if (c == ' ') continue;

      if ('0' <= c && c <= '9') {
        num = num * 10 + (c - '0');
      }
      if (c > '9' || c < '0' || (i == modifiedS.length() -1)){
        if (sign == '+') {
          stack.push(num);
        } else if (sign == '-') {
          stack.push(-num);
        } else if (sign == '*') {
          int val = stack.pop() * num;
          stack.push(val);
        } else if (sign == '/') {
          int val = stack.pop() / num;
          stack.push(val);
        }
        sign = c;
        num = 0;
      }
    }

    int total = 0;
    for (Integer n : stack) {
      total += n;
    }
    return total;
  }
}
