/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */
abstract class Node {
    public abstract int evaluate();
};

class TreeNode extends Node {
    boolean isValue;
    int value;
    String sign;
    TreeNode left;
    TreeNode right;

    public TreeNode(boolean isValue, int value, String sign) {
        this.isValue = isValue;
        this.value = value;
        this.sign = sign;
    }

    public int evaluate() {
        return helper(this);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        if (node.isValue) return node.value;

        int value1 = helper(node.left);
        int value2 = helper(node.right);
        return doOperation(node.sign, value1, value2);
    }

    private int doOperation(String sign, int value1, int value2) {
        if (sign.equals("+")) {
            return value1 + value2;
        } else if (sign.equals("-")) {
            return value1 - value2;
        } else if (sign.equals("*")) {
            return value1 * value2;
        } else if (sign.equals("/")) {
            return value1 / value2;
        }
        return -1;
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<TreeNode> stack = new Stack();

        for (int i = 0; i < postfix.length; i++) {
            String str = postfix[i];
            if (
                str.equals("+") ||
                str.equals("-") ||
                str.equals("*") ||
                str.equals("/")
            ) {
                TreeNode node = new TreeNode(false, -1, str);
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            } else {
                TreeNode node = new TreeNode(true, Integer.valueOf(str), "");
                stack.push(node);
            }
        }

        if (stack.size() > 0) {
            return stack.pop();
        } else {
            return null;
        }
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */