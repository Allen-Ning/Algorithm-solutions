class Node {
    Node prev;
    Node next;
    int value;
    Set <String> keys;

    public Node(String key, int value) {
        this.keys = new HashSet();
        this.value = value;
        if (key != null) this.keys.add(key);
    }
}

class AllOne {
    // trick -> setup dummmy head and tail will make things easier
    Node head = new Node(null, Integer.MIN_VALUE);
    Node tail = new Node(null, Integer.MAX_VALUE);

    HashMap <String, Node > map = new HashMap();

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap();
        // trick -> setup dummmy head and tail will make things easier
        head.next = tail;
        tail.prev = head;
    }

    // trick -> setup dummmy head and tail will make things easier
    //          we only need to consider inserting node between due to dummy head and tail
    private void insertNodeBetween(Node prev, Node next, Node newNode) {
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
    }

    private void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        node.prev = null;
        node.next = null;

        if (next != null) next.prev = prev;
        if (prev != null) prev.next = next;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int newValue = node.value + 1;
            Node next = node.next;

            node.keys.remove(key);
            if (next.value == newValue) {
                next.keys.add(key);
                map.put(key, next);
            } else if (next.value > newValue) {
                Node newNode = new Node(key, newValue);
                insertNodeBetween(node, node.next, newNode);
                map.put(key, newNode);
            }
            if (node.keys.size() == 0) removeNode(node);
        } else {
            if (head.next.value == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            } else if (head.next.value > 1) {
                Node newNode = new Node(key, 1);
                insertNodeBetween(head, head.next, newNode);
                map.put(key, newNode);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) return;

        Node node = map.get(key);
        node.keys.remove(key);

        if (node.value == 1) {
            if (node.keys.size() > 0) return;
            map.remove(key);
        } else if (node.value > 1) {
            int newValue = node.value - 1;
            if (node.prev != null && node.prev.value == newValue) {
                node.prev.keys.add(key);
                map.put(key, node.prev);
            } else if (node.prev != null && node.prev.value < newValue) {
                Node newNode = new Node(key, newValue);
                insertNodeBetween(node.prev, node, newNode);
                map.put(key, newNode);
            }
        }

        if (node.keys.size() == 0) removeNode(node);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.prev == null) return "";

        Set <String> keys = tail.prev.keys;
        if (keys.size() == 0) return "";
        return keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == null) return "";

        Set<String> keys = head.next.keys;
        if (keys.size() == 0) return "";
        for (String key : keys) {
            System.out.println(key);
        }
        return keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
