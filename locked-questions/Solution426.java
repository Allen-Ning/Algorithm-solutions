/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    public TreeNode treeToDoublyList(TreeNode root) {
        // trick -> we have to use TreeNode[] to track the change of last visit node
        //          TreeNode as lastVisitedNode will not be working
        //          please find the example below
        helper(root, new TreeNode[] {new TreeNode(-1)} );
        TreeNode end = root;
        while (end.right != null) end = end.right;

        TreeNode start = root;
        while (start.left != null) start = start.left;
        // trick -> the start will be dummy node by now, and we have to move the the acutal start node
        start = start.right;

        start.left = end;
        end.right = start;
        return start;
    }

    private TreeNode helper(TreeNode node, TreeNode[] lastVisitedNode) {
        if (node == null) return null;
        TreeNode left = helper(node.left, lastVisitedNode);

        node.left = lastVisitedNode[0];
        lastVisitedNode[0].right = node;
        lastVisitedNode[0] = node;

        TreeNode right = helper(node.right, lastVisitedNode);
        return node;
    }
}

// trick -> this example will print out 3 not 5
// class Playground {
//     public static void main(String[ ] args) {
//         TreeNode node = new TreeNode(3);
//         test(node);
//         System.out.println(node.val);
//     }

//     private static void test(TreeNode node) {
//         TreeNode newOne = new TreeNode(5);
//         node = newOne;
//     }
// }

// public class TreeNode {
//     public int val;
//     public TreeNode left, right;
//     public TreeNode(int val) {
//         this.val = val;
//         this.left = this.right = null;
//     }
// }