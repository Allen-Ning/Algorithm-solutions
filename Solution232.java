class MyQueue {

    Stack<Integer> s;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.s = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack();
        while(!s.isEmpty()) {
            Integer value = s.pop();
            temp.push(value);            
        }
        s.push(x);
        while (!temp.isEmpty()) {
            Integer value = temp.pop();
            s.push(value);
        } 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
