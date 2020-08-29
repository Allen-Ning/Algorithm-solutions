public class Solution {
    public int numberofDistinctIslands(int[][] grid) {
        int[] start = null;
        // trick -> hashset can reduce duplicate element such as List<Integer> or List<String>, but cannot remove element List<object> such as List<int[]>
        Set<List<Integer>> set = new HashSet();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                if (start == null) start = new int[] {i, j};

                List<Integer> list = new ArrayList();
                helper(grid, list, start[0] - i, start[1] - j, i, j);
                set.add(list);
            }
        }
        return set.size();
    }

    private void helper(int[][] grid, List<Integer> list, int baseX, int baseY, int x, int y) {
        if (x < 0 ||
            x >= grid.length ||
            y < 0 ||
            y >= grid[0].length ||
            grid[x][y] == 0
        ) return;

        grid[x][y] = 0;
        // trick -> this is very smart to move vec(baesX, baseY) to check the shape
        list.add(baseX + x);
        list.add(baseY + y);
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
        for (int[] dir : dirs) helper(grid, list, baseX, baseY, x + dir[0], y + dir[1]);
    }
}