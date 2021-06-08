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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList();
        if (root == null) return results;
        Queue<Element> queue = new LinkedList();

        // trick -> we use index to check if nodes are in the same column
        Element e = new Element(root, 0);
        queue.offer(e);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap();
        while (queue.size() > 0) { 
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                e = queue.poll();
                TreeNode current = e.node;
                List<Integer> list = map.getOrDefault(e.index, new ArrayList<Integer>());
                min = Math.min(min, e.index);
                max = Math.max(max, e.index);

                list.add(current.val);
                map.put(e.index, list);
                if (current.left != null) queue.offer(new Element(current.left, e.index - 1));
                if (current.right != null) queue.offer(new Element(current.right, e.index + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            if (!map.containsKey(i)) continue;
            results.add(map.get(i));
        }
        return results;
    }

    class Element {
        TreeNode node;
        int index;

        public Element(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
