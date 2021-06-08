/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode, List<TreeNode>> map = new HashMap();
        helper(root, null, map);

        List<Integer> results = new ArrayList();
        if (K < 0 || target == null) return results;
        if (K == 0) {
            results.add(target.val);
            return results;
        }

        Queue<TreeNode> queue = new LinkedList();

        // trick -> visited map is needed to avoid same node travel twice
        HashSet<TreeNode> visited = new HashSet();
        queue.offer(target);

        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                for (TreeNode neighbour : map.get(node)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                    }
                }
            }
            count++;

            if (count == K) break;
        }

        while(!queue.isEmpty()) {
            results.add(queue.poll().val);
        }
        return results;
    }

    private void helper(TreeNode node, TreeNode parent, HashMap<TreeNode, List<TreeNode>> map) {
        if (node == null) return;

        List<TreeNode> listByNode = map.getOrDefault(node, new ArrayList<TreeNode>());
        if (parent != null) listByNode.add(parent);
        map.put(node, listByNode);

        if (parent != null) {
            List<TreeNode> listByParent = map.getOrDefault(parent, new ArrayList<TreeNode>());
            listByParent.add(node);
            map.put(parent, listByParent);
        }

        helper(node.left, node, map);
        helper(node.right, node, map);
    }
}
