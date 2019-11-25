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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList();
        if (root == null) return list;
        int height = helper(root);

        int x = height;

        // trick -> this is base 2
        int y = (int) Math.pow(2, height) - 1;
        Integer[][] results = new Integer[x][y];

        dfs(root, results, 0, 0, y - 1);
        for (int i = 0; i < results.length; i++) {
          List<String> row = new ArrayList();
          for (int j = 0; j < results[0].length; j++) {
              if (results[i][j] == null) {
                  row.add("");
              } else {
                  row.add(results[i][j] + "");
              }
          }
          list.add(row);
        }
        return list;
    }

    private void dfs(TreeNode node, Integer[][] results, int height, int start, int end) {
        if (node == null) return;

        // trick -> make to start + (end - start) + 2 rather than end - start
        int middle = start + (end - start) / 2;
        results[height][middle] = node.val;

        dfs(node.left, results, height + 1, start, middle - 1);
        dfs(node.right, results, height + 1, middle + 1, end);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        return Math.max(helper(node.left), helper(node.right)) + 1;
    }
}
