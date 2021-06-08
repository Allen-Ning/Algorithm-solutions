/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    // using dfs makes code more short and clean
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        return helper(node, new HashMap<Node, Node>());
    }

    private Node helper(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);

        Node copyNode = new Node(node.val, new ArrayList<Node>());
        // trick -> must save the node first and then loop the neighbour
        map.put(node, copyNode);
        for (Node neighbour : node.neighbors ) {
            copyNode.neighbors.add(helper(neighbour, map));
        }

        return copyNode;
    }
}
