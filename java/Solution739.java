class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            int prevValue = temperatures[stack.peek()];
            while (!stack.isEmpty() && prevValue < temperature) {
                int resultIndex = stack.pop();
                result[resultIndex] = i - resultIndex;

                if (stack.isEmpty()) break;
                prevValue = temperatures[stack.peek()];
            }
            stack.push(i);
        }
        return result;
    }
}