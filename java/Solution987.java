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
    int step = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> results = new ArrayList();
        helper(results, root, 0, 0);
        // trick -> this check x ascending, check y descending, check value ascending order
        Collections.sort(results, (a, b) -> a[0] - b[0] == 0 ? (a[1] - b[1] == 0 ? a[2] - b[2] : b[1] - a[1]) : a[0] - b[0]);
        List<List<Integer>> lists = new ArrayList();

        if (results.size() == 0) return lists;
        List<Integer> list = new ArrayList();
        int[] pre = results.get(0);
        list.add(pre[2]);
        for (int i = 1; i < results.size(); i++) {
            int[] current = results.get(i);
            if (pre[0] == current[0]) {
                list.add(current[2]);
            } else {
                lists.add(list);
                list = new ArrayList();
                list.add(current[2]);
            }
            pre = current;
        }

        if (list.size() > 0) lists.add(list);
        return lists;

    }

    private void helper(List<int[]> results, TreeNode node, int x, int y) {
        if (node == null) return;

        helper(results, node.left, x - 1, y - 1);
        int[] result = new int[]{x, y, node.val};
        results.add(result);
        helper(results, node.right, x + 1, y - 1);
    }
}
