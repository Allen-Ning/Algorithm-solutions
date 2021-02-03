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
    public ListNode swapNodes(ListNode head, int K) {
        int k = K - 1;
        ListNode node = head;
        while (k > 0) {
            node = node.next;
            k--;
        }

        ListNode left = node;
        ListNode slow = head;
        ListNode fast = node;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode right = slow;

        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}