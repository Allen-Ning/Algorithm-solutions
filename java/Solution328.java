/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
    // 1 -> 3 -> 5 -> 6
    // 2 -> 4 -> 6
    // 1 -> 3
    // 2 -> null
    // 2 -> 4
    public ListNode oddEvenList(ListNode head) {   
        if (head == null || head.next == null || head.next.next == null) return head; 
        ListNode odd = head;
        ListNode oddStart = odd;
        ListNode even = head.next;
        ListNode evenStart = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenStart;
        return oddStart;
    }
}
