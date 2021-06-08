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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//          1
//      2         3
//  x     x   x       5
//                 x      x
// trcik -> could be done in BFS and DFS
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) return "";
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> s = new LinkedList();
    s.offer(root);

    while (!s.isEmpty()) {
        TreeNode node = s.poll();
        if (node == null) {
            sb.append("null,");
            continue;
        }
        sb.append(node.val + ",");
        s.offer(node.left);
        s.offer(node.right);
    }
    return sb.toString();
  }

  // trick -> leave nodes left and right null children will be recorded
  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) return null;
    String[] array = data.split(",");
    int start = 1;
    int end = array.length;
    Queue<TreeNode> s = new LinkedList();
    String value = array[0];

    if (value.equals("null")) return null;
    TreeNode root = new TreeNode(Integer.valueOf(value));
    s.offer(root);

    for (int i = start; i < end; i += 2) {
        TreeNode node = s.poll();
        TreeNode left = null;
        if (!array[i].equals("null")) {
            left = new TreeNode(Integer.valueOf(array[i]));
            s.offer(left);
        }

        TreeNode right = null;
        if (!array[i + 1].equals("null")) {
            right = new TreeNode(Integer.valueOf(array[i + 1]));
            s.offer(right);
        }
        node.left = left;
        node.right = right;
    }
    return root;
  }
}
