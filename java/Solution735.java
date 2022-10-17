class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int one : asteroids) {
            if (stack.size() == 0) {
                stack.push(one);
                continue;
            }

            boolean added = true;
            while (stack.size() > 0 && stack.peek() > 0 && one < 0) {
                Integer prev = stack.peek();
                if (prev == -one) {
                    stack.pop();
                    added = false;
                    break;
                } else if (Math.abs(one) < Math.abs(prev)) {
                    added = false;
                    break;
                } else {
                    added = true;
                    stack.pop();
                }
            }
            if (added) stack.push(one);
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}