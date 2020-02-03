/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
  public Node construct(int[][] grid) {
    if (grid == null || grid.length == 0) return new Node(true, true, null, null, null, null);
    return helper(grid, grid[0].length, grid.length, 0, 0);
  }

  private Node helper(int[][] grid, int w, int h, int x, int y) {
    if (w == 1 && h == 1)  return new Node(grid[x][y] == 1, true, null, null, null, null);

    int newH = h / 2;
    int newW = w / 2;

    Node topLeft = helper(grid, newW, newH, x, y);

    Node topRight = helper(grid, newW, newH, x, y + newW);

    Node bottomLeft = helper(grid, newW, newH, x + newH, y);

    Node bottomRight = helper(grid, newW, newH, x + newH, y + newW);

    boolean isSame =
        topLeft.isLeaf &&
        topRight.isLeaf &&
        bottomLeft.isLeaf &&
        bottomRight.isLeaf &&
        topLeft.val == topRight.val &&
        topRight.val == bottomLeft.val &&
        bottomLeft.val == bottomRight.val;

    if (isSame) {
        return new Node(topLeft.val, true, null, null, null, null);
    } else {
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
  }
}
