class DinnerPlates {
    List<Stack<Integer>> list;
    int capacity;
    // trick -> pushable for maintaining the index of stacks whose can push elements
    // trick -> popable for maintaining the index of stacks whose can pop elements
    TreeSet<Integer> pushable;
    TreeSet<Integer> popable;

    public DinnerPlates(int capacity) {
        this.list = new ArrayList();
        this.capacity = capacity;
        this.pushable = new TreeSet();
        this.popable = new TreeSet();
    }

    public void push(int val) {
        Integer index = pushable.ceiling(0);
        Stack<Integer> stack = null;
        if (index == null) {
            stack = new Stack<Integer>();
            list.add(stack);
            index = list.size() - 1;
            pushable.add(index);
        } else {
            stack = list.get(index);
        }
        stack.push(val);

        if (stack.size() == capacity) pushable.remove(index);
        popable.add(index);
    }

    public int pop() {
        Integer index = popable.floor(list.size());
        if (index == null) return -1;
        return popHelper(index);
    }

    public int popAtStack(int index) {
        if (list.size() - 1 < index) return -1;
        return popHelper(index);
    }

    private int popHelper(int index) {
        Stack<Integer> stack = list.get(index);
        if (stack == null || stack.size() == 0) return -1;
        int value = stack.pop();

        if (stack.size() == 0) popable.remove(index);
        pushable.add(index);
        return value;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
