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
    Node current_level = root;
    while (current_level != null) {
      Node current = current_level;
      Node nextLevelStart = new Node();
      Node prev = nextLevelStart;
      while (current != null) {
        if (current.left != null) {
          prev.next = current.left;
          prev = current.left;
        }

        if (current.right != null) {
          prev.next = current.right;
          prev = current.right;
        }

        current = current.next;
      }

      current_level = nextLevelStart.next;
    }
    return root;
  }
}
