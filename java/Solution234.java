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
    public boolean isPalindrome(ListNode head) {
        /**
            1. go to mid
            2. find even or odd
            3. break the linkedList
            4. reverse the second half of the linkedlist
            6. check the palindrome

                 s
                      f
            1 -> 2 -> 2 -> 1

                      s
                                f
            1 -> 2 -> 2 -> 1 -> 5

            s
            f
            1

            s
            f
            1 -> 2
         */
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        newHead = reverse(newHead, null);
        return checkPalindrome(head, newHead);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode node, ListNode prev) {
        if (node == null) return prev;

        ListNode newHead = reverse(node.next, node);
        node.next = prev;
        return newHead;
    }

    private boolean checkPalindrome(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) return true;
        // trick -> this needs to be true to handle special case for odd
        // e.g. 1 -> 2 -> 3 -> 2 -> 1
        //      1 -> 2 -> 3 compare 1 -> 2
        //      3 compare null return true
        if (node1 == null || node2 == null) return true;
        if (node1.val != node2.val) return false;

        return checkPalindrome(node1.next, node2.next);
    }

}