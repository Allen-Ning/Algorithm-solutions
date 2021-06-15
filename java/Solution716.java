class MaxStack {
    // trick -> another solution will be all o(1) operation, but popMax will be o(n) by using two stack
    //          one stack is to track the current value
    //          another stack is to track the current max value
    //          e.g. stack    max stack
    //                1         5
    //                4         5
    //                2         5
    //                3         5
    //                5         5
    //          if popMax is call
    //              stack    max stack
    //                1         4
    //                4         4
    //                2         3
    //                3         3
    //          each time when popMax is call,
    //          1.do o(1) to find the max value in max stack,
    //          2.do o(n) to find the max value in stack and pop the max value
    //          3.o(n) update the max stack values and add some non-max value back to the stack since the same position poped value
    class Node {
        int value;
        Node prev;
        Node next;
        int counter;

        public Node(int value, int counter) {
            this.value = value;
            this.counter = counter;
        }
    }

    Node head;
    Node tail;
    TreeSet<Node> set;
    int size;

    public MaxStack() {
        set = new TreeSet<Node>((a, b) -> b.value == a.value ? b.counter - a.counter : b.value - a.value);
        Node dummy = new Node(-1, 0);
        head = dummy;
        tail = dummy;
        this.size = 0;
    }

    public void push(int x) {
        Node node = new Node(x, ++size);

        tail.next = node;
        node.prev = tail;
        tail = node;

        set.add(node);
    }

    public int pop() {
        Node node = tail;
        Node prev = node.prev;

        prev.next = null;
        node.prev = null;

        tail = prev;

        set.remove(node);
        size--;
        return node.value;
    }

    public int top() {
        return tail.value;
    }

    public int peekMax() {
        Node node = set.first();
        return node.value;
    }

    public int popMax() {
        Node node = set.pollFirst();
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;

        node.prev = null;
        node.next = null;

        if (node == tail) tail = prev;
        return node.value;
    }
}