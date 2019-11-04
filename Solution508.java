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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> freq = new HashMap();
        helper(root, freq);
        ArrayList<Integer> list = new ArrayList();
        int max = 0;
        for (Map.Entry<Integer, Integer> each : freq.entrySet()) {
            if (each.getValue() > max) {
                max = each.getValue();
                list = new ArrayList();
                list.add(each.getKey());
            } else if (each.getValue() == max) {
                list.add(each.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int helper(TreeNode node, HashMap<Integer, Integer> freq) {
        if (node == null) return 0;
        int num = node.val;
        num += helper(node.left, freq);
        num += helper(node.right, freq);
        freq.put(num, freq.getOrDefault(num, 0) + 1);
        return num;
    }
}
