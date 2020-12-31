// trick -> another o(1) solution to use two deque and keep deque1.size == deque2.size or deque1.size == deque2.size - 1
//          which should bbe a short solution than the current one
class FrontMiddleBackQueue {
    class Node {
        Node next;
        Node prev;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Node dummyHead;
    Node dummyTail;
    Node mid;
    int counter;

    public FrontMiddleBackQueue() {
        this.dummyHead = new Node(-1);
        this.dummyTail = new Node(-1);
        connect(dummyHead, dummyTail);
        this.mid = null;
        this.counter = 0;
    }

    // e.g.
    // 1
    // 2 1
    // 3 2 1
    // 4 3 2 1
    // 5 4 3 2 1
    public void pushFront(int value) {
        Node node = new Node(value);
        Node head = dummyHead.next;
        // dummyHead -> node -> head
        connect(dummyHead, node);
        connect(node, head);
        counter++;

        if (mid == null) {
            mid = node;
        } else if (counter % 2 == 0) {
            mid = mid.prev;
        }
    }

    // e.g.
    // 1
    // 2 1 
    // 2 3 1
    // 2 4 3 1
    public void pushMiddle(int value) {
        Node node = new Node(value);
        counter++;
        if (mid == null) {
            connect(dummyHead, node);
            connect(node, dummyTail);
        } else if (counter % 2 == 1) {
            Node next = mid.next;
            // mid -> node -> next
            connect(mid, node);
            connect(node, next);
        } else {
            Node prev = mid.prev;
            // prev -> node -> mid
            connect(prev, node);
            connect(node, mid);
        }
        mid = node;
    }

    // e.g.
    // 1
    // 1 2
    // 1 2 3 
    // 1 2 3 4
    // 1 2 3 4 5
    public void pushBack(int value) {
        Node node = new Node(value);
        Node tail = dummyTail.prev;
        // tail -> node -> dummyTail
        connect(tail, node);
        connect(node, dummyTail);
        counter++;
        if (mid == null) {
            mid = node;
        } else if (counter % 2 == 1) {
            mid = mid.next;
        }
    }

    // e.g.
    // 1 2 3 4 5
    // 2 3 4 5
    // 3 4 5
    // 4 5
    // 5
    public int popFront() {
        if (dummyHead.next == dummyTail) return -1;

        // dummyHead -> next
        Node head = dummyHead.next;
        Node next = head.next;
        connect(dummyHead, next);

        counter--;
        if (counter == 0) {
            mid = null;
        } else if (counter % 2 == 1) {
            mid = mid.next;
        }
        return head.value;
    }

    // e.g.
    // 1 2 3 4 5
    // 1 2 4 5
    // 1 4 5
    // 1 5
    // 5
    public int popMiddle() {
        if (mid == null) return -1;

        // prev -> mid -> next
        Node prev = mid.prev;
        Node next = mid.next;

        connect(prev, next);
        int value = mid.value;
        counter--;

        if (counter == 0) {
            mid = null;
        } else if (counter % 2 == 0) {
            mid = mid.prev;
        } else {
            mid = mid.next;
        }
        return value;
    }

    // e.g.
    // 1 2 3 4 5
    // 1 2 3 4
    // 1 2 3
    // 1 2
    // 1
    public int popBack() {
        if (dummyTail.prev == dummyHead) return -1;

        // prev -> tail -> dummyTail
        Node tail = dummyTail.prev;
        Node prev = tail.prev;
        connect(prev, dummyTail);
        counter--;

        if (counter == 0) {
            mid = null;
        } else if (counter % 2 == 0) {
            mid = mid.prev;
        }
        return tail.value;
    }

    private void connect(Node prev, Node next) {
        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
    }
}
