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
    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return node;

        ListNode next = node.next;
        ListNode nextNext = next.next;

        next.next = node;
        node.next = helper(nextNext);
        return next;
    }
}