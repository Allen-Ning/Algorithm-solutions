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
    // TODO -> this might not be the best solution
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> biggerStack = new Stack();
        Stack<TreeNode> smallerStack = new Stack();
        helper(root, target, biggerStack, smallerStack);

        List<Integer> results = new ArrayList();
        while (k > 0 && biggerStack.size() > 0 && smallerStack.size() > 0) {
            TreeNode node1 = biggerStack.peek();
            TreeNode node2 = smallerStack.peek();
            if (Math.abs(node1.val - target) <= Math.abs(node2.val - target)) {
                addNodeToStackAndResults(results, biggerStack, "big");
            } else {
                addNodeToStackAndResults(results, smallerStack, "small");
            }
            k--;
        }

        TreeNode node = null;
        while (k > 0 && biggerStack.size() > 0) {
            addNodeToStackAndResults(results, biggerStack, "big");
            k--;
        }

        while (k > 0 && smallerStack.size() > 0) {
            addNodeToStackAndResults(results, smallerStack, "small");
            k--;
        }
        return results;
    }

    private void helper(TreeNode node, double target, Stack<TreeNode> bigger, Stack<TreeNode> smaller) {
        if (node == null) return;

        if (node.val <= target) {
            smaller.add(node);
            helper(node.right, target, bigger, smaller);
        } else {
            bigger.add(node);
            helper(node.left, target, bigger, smaller);
        }
    }

    private void addNodeToStackAndResults(List<Integer> results, Stack<TreeNode> stack, String id) {
        TreeNode node = stack.pop();
        results.add(node.val);
        if (id.equals("small")) {
            addSmaller(node, stack);
        } else {
            addBigger(node, stack);
        }
    }

    private void addBigger(TreeNode node, Stack<TreeNode> bigger) {
        TreeNode current = node.right;
        while (current != null) {
            bigger.add(current);
            current = current.left;
        }
    }

    private void addSmaller(TreeNode node, Stack<TreeNode> smaller) {
        TreeNode current = node.left;
        while (current != null) {
            smaller.add(current);
            current = current.right;
        }
    }
}