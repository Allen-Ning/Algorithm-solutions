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
    public ListNode sortList(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return node;
        if (node.next.next == null) {
            ListNode next = node.next;
            if (node.val < next.val) return node;

            node.next = null;
            next.next = node;
            return next;
        }

        ListNode leftHead = node;
        ListNode rightHead = breakMiddile(node);
        return merge(helper(leftHead), helper(rightHead));
    }

    /**
     *                            f
     *            s
     *  d -> 4 -> 2 -> 1 -> 3 -> null
     *
     *                                 f
     *                 s
     *  d -> 4 -> 2 -> 1 -> 3 -> 6 -> null
     */
    private ListNode breakMiddile(ListNode node) {
        ListNode dummy = new ListNode(-1);
        dummy.next = node;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }

    /**
     *   n1
     *   2 -> 4
     *
     *   n2
     *   1 -> 3
     *
     *             c
     *   d -> 1 -> 2
     */
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                current.next = n1;
                n1 = n1.next;
            } else {
                current.next = n2;
                n2 = n2.next;
            }
            current = current.next;
        }

        if (n1 != null)
            current.next = n1;
        if (n2 != null)
            current.next = n2;
        return dummy.next;
    }
}
