class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.head = new Node(-1, 0);
        this.tail = new Node(-2, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = this.map.get(key);
        if (node == null) return -1;

        moveToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = this.map.get(key);
        if (node == null) {
            node = new Node(key, value);
            this.map.put(key, node);
        } else {
            node.value = value;
        }

        moveToFirst(node);
        if (map.size() <= this.capacity) return;
        removeTail();
    }

    private void moveToFirst(Node node) {
        remove(node);
        Node next = this.head.next;

        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

      private void removeTail() {
        Node toBeRemovedNode = this.tail.prev;
        remove(toBeRemovedNode);
         // trick -> easy to forget to remove the key from hashmap
        this.map.remove(toBeRemovedNode.key);
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        node.prev = null;
        node.next = null;

        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */