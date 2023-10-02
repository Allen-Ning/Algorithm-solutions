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
    public ListNode middleNode(ListNode head) {
        // slow and fast

        /**
            f         f         f
            s    s    s
            1 -> 2 -> 3 -> 4 -> 5

            f         f         f          f
            s    s    s    s
            1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

            f          f
            s    s
            1 -> 2 -> null
        */
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}