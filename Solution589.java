/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> results = new ArrayList();
        helper(results, root);
        return results;
    }

    private void helper(List<Integer> list, Node node) {
        if (node == null) return;
        
        list.add(node.val);
        for (int i = 0; i < node.children.size(); i++) {
            helper(list, node.children.get(i));
        }
    }
}
