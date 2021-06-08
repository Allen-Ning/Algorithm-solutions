class MyCircularDeque {
    int k;
    int front;
    int rear;
    int[] data;
    int size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    // trick -> in general, the idea is that
    //          [ x x x x x x ]
    //            r ->   <- f
    //          [ x x x x x x ]
    //             <- f   r ->
    //          front will add element from right to left
    //          rear will add element from left to right
    //          potentiall we need to (index + k) % k or index % k to
    //          re-adjustment index to avoid index overflow
    public MyCircularDeque(int k) {
        this.k = k;
        this.front = -1;
        this.rear = -1;
        this.data = new int[k];
        this.size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;

        front = (front == -1 ? k - 1 : (--front + k) % k);
        data[front] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;

        rear = (rear == -1 ? 0 : (++rear % k));
        data[rear] = value;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;

        // trick -> be careful we need 1 to remove the the first element when front = -1
        front = (front == -1 ? 1 : ++front % k);
        size--;

        // trick -> reset to initial state
        if (isEmpty()) {
            front = -1;
            rear = -1;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        // trick -> be careful we need k - 2 to remove the last element when rear = -1
        rear = (rear == -1 ? k - 2 : (--rear + k) % k);
        size--;

        // trick -> reset to initial state
        if (isEmpty()) {
            front = -1;
            rear = -1;
        }
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;

        if (front != -1) return data[front];
        return data[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;

        if (rear != -1) return data[rear];
        return data[k - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == k ? true : false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
