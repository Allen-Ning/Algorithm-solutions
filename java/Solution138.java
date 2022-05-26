/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        clone(head);
        assignRandom(head);
        Node copyHead = head.next;
        splitNode(head);
        return copyHead;
    }

    private void clone(Node node) {
        if (node == null) return;

        Node next = node.next;
        Node copy = new Node(node.val);
        node.next = copy;
        copy.next = next;
        clone(next);
    }

    private void assignRandom(Node node) {
        if (node == null) return;

        Node next = node.next.next;
        Node copy = node.next;
        if (node.random != null) copy.random = node.random.next;
        assignRandom(next);
    }

    // node copy  next
    // A -> A' -> B -> B' 
    private void splitNode(Node node) {
        if (node == null) return;

        Node next = node.next.next;
        Node copy = node.next;
        node.next = next;

        if (next != null) copy.next = next.next;
        splitNode(next);
    }
}