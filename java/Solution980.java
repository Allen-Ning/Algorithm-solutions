class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[] start = new int[] {-1, -1};
        int[] end = new int[] {-1, -1};
        int counter = set(grid, start, end);

        int[] results = new int[] { 0 };
        grid[start[0]][start[1]] = -1;
        helper(grid, counter, results, start, end);
        return results[0];
    }

    private void helper(int[][] grid, int counter, int[] results, int[] current, int[] target) {
        if (current[0] == target[0] && current[1] == target[1] ) {
            if (counter == 0) results[0] += 1;
            return;
        }

        int[][] dirs = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            int[] next = new int[] { current[0] + dir[0], current[1] + dir[1]};
            if (next[0] >= 0 &&
                next[0] < grid.length &&
                next[1] >= 0 &&
                next[1] < grid[0].length &&
                grid[next[0]][next[1]] != -1
            ) {
                int value = grid[next[0]][next[1]];
                int currentCounter = counter;
                if (grid[next[0]][next[1]] == 0) currentCounter -= 1;

                grid[next[0]][next[1]] = -1;
                helper(grid, currentCounter, results, next, target);
                grid[next[0]][next[1]] = value;
            }
        }
    }

    private int set(int[][] grid, int[] start, int[] end) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    counter++;
                } else if (grid[i][j] == 1) {
                    // trick -> java pass by value, but the value is the of reference start/end
                    //          we cannot do start = new int[] {i, j} here
                    //          cos it will change the reference of start
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        return counter;
    }
}
