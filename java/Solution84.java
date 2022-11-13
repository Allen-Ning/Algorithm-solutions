class Solution {
    public int largestRectangleArea(int[] heights) {
        // next smaller -> increasing stack
        int max = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i <= heights.length; i++) {
            int height = 0;
            if (i < heights.length) height = heights[i];            
            if (stack.size() == 0) {
                stack.push(i);
                continue;
            }

            while (stack.size() > 0 && height < heights[stack.peek()]) {
                int index = stack.pop();
                int prevIndex = stack.size() == 0 ? -1 : stack.peek();
                int size = (i - prevIndex - 1) * heights[index];
                max = Math.max(max, size);
            }
            stack.push(i);
        }
        return max;
    }
}
