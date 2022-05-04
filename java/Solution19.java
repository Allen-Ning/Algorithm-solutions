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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = dummy;

        int counter = 1;
        while (counter < n) {
            fast = fast.next;
            counter++;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            prev = prev.next;
        }

        ListNode next = slow.next;
        prev.next = next;
        slow.next = null;
        return dummy.next;
    }
}