/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    private int[] nums;
    
    public TreeNode sortedListToBST(ListNode head) {
        this.nums = nums;
        return helper(head, null);
    }
    
    private TreeNode helper(ListNode head, ListNode end) {  
        if(head == end) return null;
        ListNode mid = findMid(head, end);
        TreeNode node = new TreeNode(mid.val);
        node.left = helper(head, mid);
        node.right = helper(mid.next, end);
        return node;
    }
    
    private ListNode findMid(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;
        while (fast!= end && fast.next!= end ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
