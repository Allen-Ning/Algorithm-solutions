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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        return helper(t);
    }

    private String helper(TreeNode node) {
        if (node == null) return "";
        
        String left = helper(node.left);
        String right = helper(node.right);
       
        String result = node.val + "";
        if (left.length() == 0 && right.length() == 0) {
            return result;
        } else if (left.length() == 0 && right.length() > 0) {
            result += "()" + "(" + right + ")";
        } else if (left.length() > 0 && right.length() == 0) {
            result += "(" + left + ")";
        } else {
            result += "(" + left + ")" + "(" + right + ")";
        }
        return result;
    }
}
