class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for (String value : ops) {
            if (value.equals("C")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (value.equals("D")) {
                if (!stack.isEmpty()) stack.push(stack.peek() * 2);
            } else if (value.equals("+")) {
                int value1 = 0;
                boolean hasValue1 = false;
                if (!stack.isEmpty()) {
                    value1 = stack.pop();
                    hasValue1 = true;
                }

                int value2 = 0;
                if (!stack.isEmpty()) value2 = stack.peek();
                if (hasValue1) stack.push(value1);
                stack.push(value1 + value2);
            } else {
                stack.push(Integer.valueOf(value));
            }
        }

        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }
}
