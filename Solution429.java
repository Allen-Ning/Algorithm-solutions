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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> list = new LinkedList();
        List<List<Integer>> results = new ArrayList();
        if (root == null) return results;
        list.add(root);
        while (list.size() > 0) {
            List<Integer> result = new ArrayList();
            // trick is here - record how many nodes for each level
            int length = list.size();
            while (length > 0) {
                Node node = list.poll();
                result.add(node.val);
                for (Node child : node.children) {
                    list.add(child);
                }
                length--;
            }
            results.add(result);
        }
        return results;
    }
}
