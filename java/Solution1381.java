class CustomStack {

    int maxSize;
    Stack<Integer> stack;
    int[] increasement;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Stack();
        this.increasement = new int[maxSize];
    }

    public void push(int x) {
        if (stack.size() >= maxSize) return;

        stack.add(x);
    }

    public int pop() {
        if (stack.size() == 0) return -1;

        int value = increasement[stack.size() - 1];
        // trick -> we need to clear the increasement array
        //          e.g. 1. the size of stack is 3
        //               2. increment(3, 10)
        //               3. pop
        //               4. add
        //               5. increment(3, 5)
        increasement[stack.size() - 1] = 0;
        if (stack.size() >= 2) increasement[stack.size() - 2] += value;

        return stack.pop() + value;
    }

    public void increment(int k, int val) {
        if (stack.size() == 0) return;

        // trick -> we cannot set k more than the current size of stack
        //          e.g. the size of stack is 1
        //               k is 5
        int index = Math.min(stack.size(), k) - 1;
        increasement[index] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */