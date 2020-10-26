public class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack();
        int i = 0;
        long value = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                value = value * 10 + (c - '0');
                if (i == s.length() - 1 ||
                   (i + 1 < s.length() && (s.charAt(i + 1) < '0' || s.charAt(i + 1) > '9'))) {
                       value = getValue(stack, value);
                       if (value != 0) stack.push(String.valueOf(value));
                       value = 0;
                   }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(String.valueOf(c));
            } else if (c == '(') {
                stack.push("(");
            } else if (c == ')') {
                String str = stack.pop();
                long sum = 0;
                int sign = 1;
                long temp = 0;
                while (!str.equals("(")) {
                    if (str.equals("+")) {
                        sign = 1;
                        sum += sign * temp;
                        temp = 0;
                    } else if (str.equals("-")) {
                        sign = -1;
                        sum += sign * temp;
                        temp = 0;
                    } else {
                        temp = Long.valueOf(str);
                    }
                    str = stack.pop();
                }
                if (temp != 0) sum += temp;
                sum = getValue(stack, sum);
                if (sum != 0) stack.push(String.valueOf(sum));
            }
            i++;
        }
        if (value != 0) stack.push(String.valueOf(value));

        long result = 0;
        int sign = 1;
        long temp = 0;
        while (stack.size() > 0) {
            String str = stack.pop();
            if (str.equals("-")) {
                sign = -1;
                result += sign * temp;
                temp = 0;
            } else if (str.equals("+")) {
                sign = 1;
                result += sign * temp;
                temp = 0;
            } else {
                temp = Long.valueOf(str);
            }
        }
        if (temp != 0) result += temp;
        return (int) result;
    }

    private long getValue(Stack<String> stack, long value) {
        if (stack.size() > 0 && stack.peek().equals("*")) {
            stack.pop();
            value = Long.valueOf(stack.pop()) * value;
        } else if (stack.size() > 0 && stack.peek().equals("/")) {
            stack.pop();
            value = Long.valueOf(stack.pop()) / value;
        }
        return value;
    }
}
