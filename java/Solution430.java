/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        connect(head, null);
        return head;
    }

    private void connect(Node node, Node next) { 
        while (node != null) {
            if (node.child != null) {
                Node nextNode = node.next;
                connect(node.child, nextNode);
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
                node = node.next;
            } else if (node.next != null) {
                node = node.next;
            } else if (node.next == null){
                node.next = next;
                if (next != null) next.prev = node;
                return;
            }
        }
    }
}
