class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        char[] array = s.toCharArray();
        int sign = 1;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            char value = array[i];
            if (value >= '0' && value <= '9') { 
                int preValue = value - '0';
                while (i + 1 < array.length && array[i + 1] >= '0' && array[i + 1] <= '9') {
                    preValue = preValue * 10 + (array[i + 1] - '0');     
                    i++;
                }
                result += sign * preValue;
            } else if (value == '+' || value == '-') { 
                sign = (value == '+' ? 1 : -1); 
            } else if (value == '(') {
                stack.push(result);
                stack.push(sign);

                sign = 1;
                result = 0;
            } else if (value == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }

}
