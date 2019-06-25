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
    int expectedSum;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.expectedSum = sum;
        List<Integer> list = new ArrayList();
        result = new ArrayList();
        helper(root, list, 0);
        return result;
    }

    private void helper(TreeNode node, List<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null && expectedSum == (sum + node.val)) {
            result.add(new ArrayList(list));
        }
        helper(node.left, list, sum + node.val);
        helper(node.right, list, sum + node.val);
        list.remove(list.size() -1);
        return;
    }
}
