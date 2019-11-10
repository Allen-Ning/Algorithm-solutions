class Solution {
    // [1,1,2],
    // [1,1,0],
    // [1,0,1]
    // trick -> easy question, but a little bit hard to understand the example
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return image;
        if (newColor == image[sr][sc]) return image;

        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if (image[sr][sc] != oldColor) return;

        image[sr][sc] = newColor;

        helper(image, sr + 1, sc, oldColor, newColor);
        helper(image, sr, sc + 1, oldColor, newColor);
        helper(image, sr - 1, sc, oldColor, newColor);
        helper(image, sr, sc - 1, oldColor, newColor);
    }
}
