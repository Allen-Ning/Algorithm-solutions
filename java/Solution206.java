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
    public ListNode reverseList(ListNode head) {
      /**
      p  n
         1 -> 2

         p    n
         1 -> 2

              p    n
         1 -> 2
       */
        return helper(head, null);
    }

    private ListNode helper(ListNode current, ListNode prev) {
        // trick -> we need to return prev
        if (current == null) return prev;

        ListNode newHead = helper(current.next, current);

        // trick -> the original head node will point to null
        current.next = prev;

        return newHead;
    }
}