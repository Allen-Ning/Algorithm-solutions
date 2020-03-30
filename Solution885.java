class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] results = new int[R * C][2];
        int counter = 1;
        results[0] = new int[]{r0, c0};
        int step = 1;
        int x = r0;
        int y = c0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDir = 0;
        while (counter < R * C) {
            // trick -> step will + 1 every two operations such as right and down
            for (int i = 0; i <= 1; i++) {
                for (int j = 1; j <= step; j++) {
                    x += dirs[currentDir][0];
                    y += dirs[currentDir][1];
                    if (x >= 0 && x < R && y >= 0 && y < C) results[counter++] = new int[] {x, y};
                }
                currentDir = (currentDir + 1) % 4;
            }
            step++;
        }
        return results;
    }
}
