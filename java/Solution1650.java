/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        // trick -> both of a and b running the same length of path
        //          a and b will meet in the intersection point
        while (a != b) {
            a = (a == null ? q : a.parent);
            b = (b == null ? p : b.parent);
        }
        return a;
    }
}