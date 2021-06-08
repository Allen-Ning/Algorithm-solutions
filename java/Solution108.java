/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int[] nums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
    
    private TreeNode helper(int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(start, mid - 1);
        node.right = helper(mid + 1, end);
        return node;
    }
}
