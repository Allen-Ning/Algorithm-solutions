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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        int count = 1;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        ListNode tail = current;

        k %= count;
        // special case - k is 0, which means no need to do anything
        if (k == 0) return head;

        int breakCounter = count - k - 1;
        current = head;
        while (breakCounter > 0) {
            breakCounter--;
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;

        tail.next = head;
        return newHead;
    }
}