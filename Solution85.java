class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }

            }
            int value = findMaximium(heights);
            max = Math.max(max, value);
        }
        return max;
    }

    private int findMaximium(int[] heights) {
        Stack<Integer> stack = new Stack();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            int topIndex = stack.peek();
            while (heights[topIndex] > height) {

                int popedValue = stack.pop();
                // trick -> special case nothing in the stack
                if (stack.isEmpty()) {
                    max = Math.max(max, i * heights[popedValue]);
                } else {
                    int value = (i - stack.peek() - 1) * heights[popedValue];
                    max = Math.max(max, value);
                }

                if (stack.isEmpty()) break;
                topIndex = stack.peek();
            }
            stack.push(i);
        }
        return max;
    }
}
