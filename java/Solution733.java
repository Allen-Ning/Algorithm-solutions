// bff
class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originColor = image[sr][sc];
        // trick -> corner case - the starting pixel is same as color to filled
        if (originColor == color) return image;

        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {sr, sc});

        int[][] dirs = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                image[point[0]][point[1]] = color;

                for (int[] dir : dirs) {
                    int x = dir[0] + point[0];
                    int y = dir[1] + point[1];

                    if (x < 0 ||
                        x >= image.length ||
                        y < 0 ||
                        y >= image[0].length ||
                        image[x][y] != originColor
                    ) continue;

                    queue.offer(new int[] {x, y});
                }
            }
        }
        return image;
    }
}

// dfs
class Solution2 {
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


