class Solution {
    //  0    1   2 . 3 . 4 . 5  6 .  7
    // [73, 74, 75, 71, 69, 72, 76, 73]
    //  1   1   ?    ?   1   1   ?   0
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] results = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()) {
                int topIndex = stack.peek();
                if (T[i] > T[topIndex]) {
                    results[topIndex] = i - topIndex;
                    stack.pop();
                } else {
                    break;
                }
            }
            if (i < (T.length - 1) && T[i] < T[i + 1]) {
                results[i] = 1;
            } else {
                stack.push(i);
            }
        }
        return results;
    }
}
