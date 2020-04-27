/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return helper(root);
    }

    private int helper(Node node) {
        if (node == null) return 0;

        int max = 0;
        for (int i = 0; i < node.children.size(); i++) {
            max = Math.max(helper(node.children.get(i)), max);
        }
        return max + 1;
    }
}
