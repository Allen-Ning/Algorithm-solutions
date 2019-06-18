// Queue methods 
// poll, remove, offer
class MyStack {

    Queue<Integer> list;

    /** Initialize your data structure here. */
    public MyStack() {
        list = new LinkedList();
    }

    // 1 2 3 4 5 6
    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
        for (int i = 0; i < list.size() - 1; i ++) {
            list.offer(list.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.poll();
    }

    /** Get the top element. */
    public int top() {
        return list.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
