/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    List<TreeNode> list = new ArrayList();
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        // trick -> this is for calculation the index easier
        list.add(null);
        list.add(root);
        // trick -> the for loop implemtation is very clear than while loop
        //          this is basically bfs traversal
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).left == null) break;
            list.add(list.get(i).left);
            if (list.get(i).right == null) break;
            list.add(list.get(i).right);
        }
    }

    // trick -> to use index / 2 to find the parent
    //          to use index % 2 to check the inserted node (left or right child)
    public int insert(int v) {
        int index = list.size();
        TreeNode parent = list.get(index / 2);
        TreeNode newNode = new TreeNode(v);
        if (index % 2 == 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        list.add(newNode);
        return parent.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
