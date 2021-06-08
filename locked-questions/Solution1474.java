/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        helper(head, m, n);
        return dummy.next;
    }

    private void helper(ListNode node, int keepedCounter, int skipedCounter) {
        if (node == null) return;

        ListNode keepedNode = keep(node, keepedCounter - 1);
        ListNode nextKeepedNode = skip(keepedNode.next, skipedCounter);
        keepedNode.next = nextKeepedNode;
        helper(nextKeepedNode, keepedCounter, skipedCounter);
    }

    private ListNode keep(ListNode node, int counter) {
        if (node.next == null) return node; 
        if (counter == 0) return node;

        return keep(node.next, counter - 1);
    }

    private ListNode skip(ListNode node, int counter) {
        if (node == null) return null;
        if (counter == 0) return node;

        return skip(node.next, counter - 1);
    }
}