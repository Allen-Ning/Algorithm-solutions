class MinStack {
    Stack<Item> stack;

    public MinStack() {
        stack = new Stack<Item>();
    }

    public void push(int val) {
        int currentMin = val;
        if (stack.size() > 0) {
            Item peek = stack.peek();
            currentMin = Math.min(val, peek.min);
        }
        Item item = new Item(val, currentMin);
        stack.push(item);
    }

    public void pop() {
        if (stack.size() == 0) return;
        stack.pop();
    }

    public int top() {
        if (stack.size() == 0) return -1;
        Item item = stack.peek();
        return item.value;
    }

    public int getMin() {
        if (stack.size() == 0) return -1;
        Item item = stack.peek();
        return item.min;
    }

    class Item {
        int value;
        int min;

        public Item(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */