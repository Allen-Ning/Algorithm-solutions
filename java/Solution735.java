class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid > 0) {
                stack.push(i);
                continue;
            }

            // peak ->
            // asteroid <-
            // trick -> do the while loop first to make the logic more clear
            //          the goal is to destroy the smaller asteroid in the stack as long as the current asteroid is larger
            while (stack.size() > 0 && asteroids[stack.peek()] > 0 && asteroids[stack.peek()] < Math.abs(asteroid)) stack.pop();

            if (stack.size() > 0 && asteroids[stack.peek()] > 0 && asteroids[stack.peek()] == Math.abs(asteroid)) {
                stack.pop();
                continue;
            }

            if (stack.size() > 0 && asteroids[stack.peek()] > 0 && asteroids[stack.peek()] > Math.abs(asteroid)) {
                continue;
            }

            stack.push(i);
        }

        int[] results = new int[stack.size()];
        for (int i = results.length - 1; i >= 0; i--) {
            results[i] = asteroids[stack.pop()];
        }
        return results;
    }
}