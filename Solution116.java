/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
  public Node connect(Node root) {
    if (root == null) return null;

    Node start_level = root;
    while (start_level != null) {
      Node start = start_level;
      while (start != null) {
        if (start.left != null) { start.left.next = start.right; }

        if (start.right != null && start.next != null) { start.right.next = start.next.left; }

        start = start.next;
      }
      start_level = start_level.left;
    }
    return root;
  }
}
