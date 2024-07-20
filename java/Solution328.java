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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        /**
               o.   e.   o.   e.   o.
            // 1 -> 2 -> 3 -> 4 -> 5 -> null

               o.   e.   o.   e.   o.   e.
            // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null -> null
         */
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddCurrent = oddHead;
        ListNode evenCurrent = evenHead;

        while (oddCurrent != null && oddCurrent.next != null && oddCurrent.next.next != null) {
            // trick -> change odd.next first because odd is before even
            //                o.   e
            //          e.g.  1 -> 2 -> 3 -> 4 -> 5 -> null
            //                1 -> 2 -> 4 -> 5 -> null (if we move even first)
            oddCurrent.next = oddCurrent.next.next;
            evenCurrent.next = evenCurrent.next.next;

            oddCurrent = oddCurrent.next;
            evenCurrent = evenCurrent.next;
        }

        oddCurrent.next = evenHead;
        return oddHead;
    }
}