/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    
    // 1 -> 1' -> 2 -> 2'
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node node = head;

        // build A->A'->B->B'->C->C'->D->D'
        while (node != null) {
            Node nextNode = node.next;
            Node cpNode = new Node(node.val, null, null);

            node.next = cpNode;
            cpNode.next = nextNode;
    
            node = nextNode;
        }
        
        // assign random pointer
        node = head;
        while (node != null) {
            if (node.random != null) node.next.random = node.random.next;
            node = node.next.next;
        }
        
        // split linked list
        // 1 -> 1' -> 2 -> 2'
        node = head;
        Node newHead = head.next;
        Node cur = newHead;
        while (node != null && node.next.next != null) {
            Node nextNode = node.next.next;
            cur.next = nextNode.next;
            node.next = nextNode;
            
            cur = nextNode.next;
            node = nextNode;
        }
        node.next = null;
        return newHead;
        
    }
    
}
