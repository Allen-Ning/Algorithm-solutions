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

    //    	3
    //     / \
    //    9  20
    //   / \
    //  7   15

    //             0  1  2  3   4
    // preorder = [3, 9, 7, 15, 20]
    // inorder  = [7, 9, 15, 3, 20]
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder== null || preorder.length == 0 || inorder.length == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        return helper(0, inorder.length - 1, 0);
    }

    private TreeNode helper(int start, int end, int parentIndex) {
        if (start > end) return null;
        TreeNode parentNode = findParentNode(parentIndex);
        int nodeIndex = findParentNodeIndex(parentNode, start, end);

        parentNode.left = helper(start, nodeIndex - 1, parentIndex + 1);
        parentNode.right = helper(nodeIndex + 1, end, nodeIndex - start + parentIndex + 1);
        return parentNode;
    }

    private TreeNode findParentNode(int parentIndex) {
        TreeNode node = new TreeNode(preorder[parentIndex]);
        return node;
    }

    private int findParentNodeIndex(TreeNode parentNode, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == parentNode.val) {
                return i;
            }
        }
        return -1;
    }
}
