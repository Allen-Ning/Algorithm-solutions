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
    public TreeNode str2tree(String s) {
        if (s.equals("")) return null;

        return helper(s, 0, s.length() - 1);
    }

    private TreeNode helper(String s, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(s.charAt(start) - '0');

        int index = start;
        StringBuilder sb = new StringBuilder();
        while (index <= end && s.charAt(index) != '(') {
            sb.append(s.charAt(index++));
        }
        TreeNode node = new TreeNode(Integer.valueOf(sb.toString()));
        Stack<Integer> stack = new Stack();
        int leftStartIndex = index;
        while (index <= end) {
            if (s.charAt(index) == '(') {
                stack.push(index);
            } else if (s.charAt(index) == ')') {
                if (s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (stack.size() == 0) break;
                }
            }
            index++;
        }
        int leftEndIndex = index;
        int rightStartIndex = leftEndIndex + 1;
        int rightEndIndex = end;
        node.left = helper(s, leftStartIndex + 1, leftEndIndex - 1);
        node.right = helper(s, rightStartIndex + 1, rightEndIndex - 1);
        return node;
    }
}