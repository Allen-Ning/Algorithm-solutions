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
    public int pairSum(ListNode head) {
        // f                   f
        //      s    s
        // A -> B -> C -> D -> E -> F
        // find mid
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = fast.next;
        // f                   f
        //      s    s
        // A -> B -> C <- D <-E <- F
        reverse(slow, slow.next);

        // trick -> needs to remove slow.next to cut the linked list into two linked list
        //          avoid C -> D and C <- D in the above example
        slow.next = null;

        int result = 0;
        while (head != null && tail != null) {
            result = Math.max(result, head.val + tail.val);
            head = head.next;
            tail = tail.next;
        }
        return result;
    }

    private void reverse(ListNode prev, ListNode node) {
        if (node == null) return;

        ListNode next = node.next;
        node.next = prev;
        reverse(node, next);
    }
}