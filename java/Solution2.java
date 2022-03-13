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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        helper(l1, l2, dummy, 0);
        return dummy.next;
    }

    private void helper(ListNode l1, ListNode l2, ListNode parent, int leadingZero) {
        // trick -> check leadingZero to cover the case
        //          e.g. l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        if (l1 == null && l2 == null && leadingZero == 0) return;

        int temp = leadingZero;
        if (l1 != null) {
            temp += l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            temp += l2.val;
            l2 = l2.next;
        }

        ListNode current = new ListNode(temp % 10);
        parent.next = current;
        helper(l1, l2, current, temp / 10);
    }
}