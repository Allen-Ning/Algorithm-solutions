class MyCircularQueue {

    int[] list;
    int head = 0;
    // trick -> set end as -1 as the begining
    int end = -1;
    int length = 0;
    int k;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        list = new int[k];
        this.k = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (length == k) return false;
        
        // trick -> move the end to the start of array
        end = ++end % k;
        list[end] = value;
        length++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (length == 0) return false;
        
        head = ++head % k;
        length--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (length == 0) return -1;
        return list[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (length == 0) return -1;
        return list[end];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return length == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return length == k;
    }
}
