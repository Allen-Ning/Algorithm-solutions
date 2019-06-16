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
    //  0 1  2 3  4 
    // [9,3,15,20,7]
    // [9,15,7,20,3]

    int[] inorder, postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        return helper(0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode helper(int inStartIndex, int inEndIndex, int postOrderIndex) {
        if (inStartIndex > inEndIndex) return null;
        TreeNode node = findParentNode(postOrderIndex);
        int parentIndex = findParentInorderIndex(inStartIndex, inEndIndex, node);
        node.left = helper(inStartIndex, parentIndex - 1,  postOrderIndex - (inEndIndex - parentIndex) - 1);
        node.right = helper(parentIndex + 1, inEndIndex, postOrderIndex - 1);
        return node;
    }

    private TreeNode findParentNode(int postOrderIndex) {
        TreeNode node = new TreeNode(postorder[postOrderIndex]);
        return node;
    }

    private int findParentInorderIndex(int inStartIndex, int inEndIndex, TreeNode node) {
        for(int i = inStartIndex; i <= inEndIndex; i++) {
            if (node.val == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
