class LRUCache {
    HashMap<Integer, Node> map;
    Node dummyHead;
    Node dummyTail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dummyHead = new Node(0, 0);
        this.dummyTail = new Node(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.map = new HashMap();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            map.put(key, node);
            remove(node);
            addFirst(node);
        } else {
            node = new Node(key, value);
            addFirst(node);
            map.put(key, node);
            if (map.size() > capacity) {
                map.remove(dummyTail.prev.key);
                removeTail();
            }
        }
    }

    private void addFirst(Node node) {
        Node next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = next;
        next.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    private void removeTail() {
        Node node = dummyTail.prev;
        remove(node);
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

