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
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    HashMap<String, Integer> map = new HashMap();
    HashMap<TreeNode, String> history = new HashMap();
    List<TreeNode> results = new ArrayList();
    helper(map, history, results, root);
    return results;
  }

  private void helper(HashMap<String, Integer> map, HashMap<TreeNode, String> history, List<TreeNode> results, TreeNode node) {
    if (node == null) return;

    String path = getPath(history, node);
    int count = map.getOrDefault(path, 0) + 1;
    if (count == 2) results.add(node);
    map.put(path, count);

    helper(map, history, results, node.left);
    helper(map, history, results, node.right);
  }

  private String getPath(HashMap<TreeNode, String> history, TreeNode node) {
    if (node == null) return "#";
    if (history.containsKey(node)) return history.get(node);

    String path = node.val + "," + getPath(history, node.left) + "," + getPath(history, node.right);
    history.put(node, path);
    return path;
  }
}
