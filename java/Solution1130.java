class Solution {
    // dp o(n ^ 3) solution
    public int mctFromLeafValues(int[] array) {
        int[][] maxValues = max(array);
        int[][] dp = new int[array.length][array.length];
        for (int d = 1; d < array.length; d++) {
            for (int i = 0; i < array.length; i++) {
                if (i + d >= array.length) continue;
                int j = d + i;

                if (d == 1) {
                    dp[i][i + d] = array[i] * array[i+ d];
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < i + d; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + maxValues[i][k] * maxValues[k + 1][j]);
                }
            }
        }
        return dp[0][array.length - 1];
    }

    private int[][] max(int[] array) {
        int[][] results = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                results[i][j] = array[j];
                if (j > i) results[i][j] = Math.max(results[i][j], results[i][j - 1]);
            }
        }
        return results;
    }

    // Stack O(n)
    public int mctFromLeafValues2(int[] array) {
        Stack<Integer> stack = new Stack();
        // trick -> this is pre-set value so that all values [0, array.length - 2] in array have left value and right value
        stack.push(Integer.MAX_VALUE);
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            // trick -> this is to keep a decreasing monotone stack
            while (stack.peek() <= array[i]) {
                int drop = stack.pop();
                result += drop * Math.min(stack.peek(), array[i]);
            }
            stack.push(array[i]);
        }

        // trick -> Integer.MAX_VALUE will always keep in the stack
        while (stack.size() > 2) result += stack.pop() * stack.peek();
        return result;
    }
}