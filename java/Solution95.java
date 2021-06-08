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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList();
        if (start > end) {
            // trick -> this is the most trick part, we need to return list with value null instead of null
            //          cos we need to loop it through leftNodes/rightNodes below 
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
