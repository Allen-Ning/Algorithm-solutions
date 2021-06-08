/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // trick -> do not include # for empty node.
    // [5, [1, [0.5], [3, 2.5, 3.5] 6]
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String value = helper(root);
        return value;
    }

    private String helper(TreeNode node) {
        if (node == null) return "";

        String str = node.val + ",";
        str += helper(node.left);
        str += helper(node.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] values = data.split(",");
        if (values.length == 0) return null;
        return build(values, 0, values.length - 1);
    }

    // trick -> make sure the parent node following the same rule during recursive
    private TreeNode build(String[] values, int start, int end) {
        if  (start > end) return null;
        if  (start == end) {
            return new TreeNode(Integer.valueOf(values[start]));
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(values[start]));
        int mid = start + 1;
        while (mid <= end) {
            if (Integer.valueOf(values[mid]) > node.val) break;
            mid++;
        }

        node.left = build(values, start + 1, mid - 1);
        node.right = build(values, mid, end);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
