/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// bfs
class Solution {
    public Node cloneGraph(Node root) {
        if (root == null) return root;

        HashMap<Node, Node> map = new HashMap();
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        map.put(root, new Node(root.val));

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                Node copy = map.get(node);

                for (Node neighbor : node.neighbors) {
                    // trick -> this indicates if the original node hasn't been visisted
                    if (!map.containsKey(neighbor)) queue.offer(neighbor);

                    Node copyNeighbor = map.get(neighbor);
                    if (copyNeighbor == null) {
                        copyNeighbor = new Node(neighbor.val);
                        map.put(neighbor, copyNeighbor);
                    }
                    copy.neighbors.add(copyNeighbor);
                }
            }
        }
        return map.get(root);
    }
}

// dfs
class Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        return helper(node, new HashMap<Node, Node>());
    }

    private Node helper(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);

        Node copyNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, copyNode);
        for (Node neighbour : node.neighbors ) {
            copyNode.neighbors.add(helper(neighbour, map));
        }
        return copyNode;
    }
}