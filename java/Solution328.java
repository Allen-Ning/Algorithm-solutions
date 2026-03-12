/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode() {}
 *   ListNode(int val) { this.val = val; }
 *   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        // trick -> change odd.next first because odd is before even
        // o. e
        // e.g. 1 -> 2 -> 3 -> 4 -> 5 -> null
        // 1 -> 2 -> 4 -> 5 -> null (if we move even first)
        while (even != null && even.next != null) {
            ListNode oddNext = even.next;
            ListNode evenNext = even.next.next;

            odd.next = oddNext;
            odd = oddNext;

            even.next = evenNext;
            even = even.next;
        }

        // the odd is the tail
        odd.next = evenHead;
        return head;
    }
}
