class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];

            // trick -> we need to maintain a decreasing stack
            while (stack.size() > 0 && temperature > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }
        return result;
    }
}