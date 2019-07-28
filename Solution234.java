/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // 1 -> 2 -> 3 <- 2 <- 1
    // fast.next == null
         //  dummy
              //prev cur  next
    // 1 -> 2  2 <- 1 
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode start1 = head;
        ListNode start2 = null;
        
        // odd
        if (fast.next == null) {
            start2 = reverse(mid);
        } else {
            start2 = reverse(mid.next);
            slow.next = null;
        }

        while (start1 != null && start2 != null) {
            if (start1.val != start2.val) return false;
            start1 = start1.next;
            start2 = start2.next;
        }
        
        if (start1 != null && start2 == null) return false;
        if (start2 != null && start1 == null) return false;
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = node;
        ListNode cur = node.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node.next = null;
        return prev;
    }
}
