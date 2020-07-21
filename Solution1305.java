/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        helper(root1, list1);
        helper(root2, list2);

        if (list1.size() == 0) return list2;
        if (list2.size() == 0) return list1;
        return merge(list1, list2);
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;

        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList();
        int size = list1.size() <= list2.size() ? list1.size() : list2.size(); 

        int p1 = 0;
        int p2 = 0;
        while (p1 < list1.size() && p2 < list2.size()) {
            int value1 = list1.get(p1);
            int value2 = list2.get(p2);
            if (value1 <= value2) {
                list.add(value1);
                p1++;
            } else {
                list.add(value2);
                p2++;
            }
        }

        while (p1 < list1.size()) list.add(list1.get(p1++));
        while (p2 < list2.size()) list.add(list2.get(p2++));
        return list;
    }
}
