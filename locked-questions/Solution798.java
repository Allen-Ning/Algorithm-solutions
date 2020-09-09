/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // trick -> not ac please double check
    public ListNode insert(ListNode node, int x) {
        if (node == null) return new ListNode(x);

        ListNode start = node;
        ListNode current = node.next;
        ListNode min = node;
        ListNode max = node;
        while (current != start) {
            if (current.val < min.val) min = current;
            if (current.val > max.val) max = current;
            current = current.next;
        }

        // trick -> e.g. 1 (start) -> 2 -> 3 -> 3 -> 4 -> 5 (end) -> 1 (start)
        //          if value >= 5 (max) or value =< 1 (min), insert after 5 and before 1
        if (x >= max.val || x <= min.val) {
            ListNode insertedNode = new ListNode(x);
            max.next = insertedNode;
            insertedNode.next = min;
        }

        helper(node, min, max, x);
        return node;
    }

    private void helper(ListNode node, ListNode min, ListNode max, int x) {
        ListNode nextNode = node.next;

        // trick -> e.g. 1 (stat) -> 2 -> 3- > 3 -> 4 -> 5 (end) -> 1 (start)
        //          if value > 1 && value < 5 insert in the middle
        if (x >= node.val && x <= nextNode.val) {
            ListNode insertedNode = new ListNode(x);
            node.next = insertedNode;
            insertedNode.next = nextNode;
            return;
        }
        helper(nextNode, min, max, x);
    }
}