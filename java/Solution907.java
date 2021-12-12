class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] leftSmaller = new int[length];
        int[] rightSmaller = new int[length];

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < length; i++) {
            int num = arr[i];

            while (!stack.isEmpty()) {
                int topIndex = stack.peek();
                if (arr[topIndex] <= num) break;

                int index = stack.pop();
                rightSmaller[index] = i - index;
            }
            stack.push(i);
        }

        stack = new Stack();
        for (int i = length - 1; i >= 0; i--) {
            int num = arr[i];

            while (!stack.isEmpty()) {
                int topIndex = stack.peek();
                // trick -> this is fixed the left side
                //          which mean the sub array of left side cannot expand more
                //          if two numbers are same value e.g. [x, x, 5, x, x, 5, xx]
                //
                if (arr[topIndex] < num) break;
                int index = stack.pop();
                leftSmaller[index] = index - i;
            }
            stack.push(i);
        }

        long result = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < length; i++) {
            if (leftSmaller[i] == 0) leftSmaller[i] = i + 1;
            if (rightSmaller[i] == 0) rightSmaller[i] = length - i;

            result += leftSmaller[i] * rightSmaller[i] * (long) arr[i];
            result %= mod;
        }
        return (int) result;
    }
}