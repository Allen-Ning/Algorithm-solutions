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
    public void reorderList(ListNode head) {
        // trick -> only one node
        if (head == null || head.next == null) return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode secondHalfHead = reverse(mid, null);

        ListNode current = dummy;
        while (head != null && secondHalfHead != null) {
            current.next = head;
            head = head.next;

            current = current.next;

            current.next = secondHalfHead;
            secondHalfHead = secondHalfHead.next;

            current = current.next;
        }

        if (head != null) current.next = head;
        if (secondHalfHead != null) current.next = secondHalfHead;
    }

    private ListNode reverse(ListNode node, ListNode prev) {
        if (node == null) return prev;

        ListNode tail = reverse(node.next, node);
        node.next = prev;
        return tail;
    }
}