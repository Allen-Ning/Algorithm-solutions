/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        return dummy.val == 0 ? head : dummy;
    }

    private int helper(ListNode node) {
        if (node == null) return 1;

        int value = helper(node.next) + node.val;
        node.val = value % 10;
        return value / 10;
    }
}