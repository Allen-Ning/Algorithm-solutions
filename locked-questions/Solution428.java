/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

// trick -> this question doesn't AC due to the broken signature. double check
public class Solution {
    public String serialize(ArrayList<DirectedGraphNode> nodes) {
        if (nodes.size() == 0) return "";
        DirectedGraphNode root = nodes.get(0);
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                DirectedGraphNode node = queue.poll();
                sb.append(i + ",");
                for (DirectedGraphNode child : node.neighbors) {
                    queue.offer(child);
                    sb.append(child.label + ",");
                }
            }
            sb.append("|");
        }
        return sb.toString();
    }

    public UndirectedGraphNode deserialize(String data) {
        if (data.length() == 0) return null;

        DirectedGraphNode root = null;
        String[] levels = data.split("|");

        List<DirectedGraphNode> parents = new ArrayList();
        List<DirectedGraphNode> currents = null;
        for (int i = 0; i < levels.length; i++) {
            currents = new ArrayList();
            String level = levels[i];
            String[] items = level.split(",");
            DirectedGraphNode parent = null;
            for (int j = 0; j < items.length; j++) {
                String item = items[j];
                if (j == 0) {
                    if (root == null) root = new DirectedGraphNode(Integer.valueOf(item));
                    if (parents.size() > 0) parent = parents.get(j);
                } else {
                    DirectedGraphNode node = new DirectedGraphNode(Integer.valueOf(item));
                    parent.neighbors.add(node);
                    currents.add(node);
                }
            }
            parents = currents;
        }
        return root;
    }
}