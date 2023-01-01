/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);

        if (head == null) {
            node.next = node;
            return node;
        }

        Node current = head;
        Node next = current.next;
        Node max = head;
        Node min = head;

        while (current != next) {
            if (current.val <= insertVal && insertVal <= next.val) {
                current.next = node;
                node.next = next;
                return head;
            }

            current = next;
            next = next.next;

            // second round 
            if (current == head) break;

            // trick -> we have to break first if this is the second around to avoid case like below
            //              e.g. 
            //                  [3,3,3]
            //                  0
            if (current.val >= max.val) max = current;
            if (current.val < min.val) min = current;
        }

        if (insertVal > max.val) {
           max.next = node;
           node.next = min;
        } else {
           max.next = node;
           node.next = min;
        }

        return head;
    }
}