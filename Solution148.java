/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        return helper(head);
    }

    private ListNode helper(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode mid = findMiddle(node);
        ListNode node1 = node;
        ListNode node2 = mid.next;
        mid.next = null;

        return merge(helper(node1), helper(node2));
    }

    private ListNode findMiddle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }

        ListNode current = (node1 == null ? node2 : node1);
        while (current != null) {
            node.next = current;
            node = current;
            current = current.next;
        }
        return dummy.next;
    }
}
