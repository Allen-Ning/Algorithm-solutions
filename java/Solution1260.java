class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> results = new ArrayList();
        for (int i = 0; i < m; i++) {
            List<Integer> result = new ArrayList();
            for (int j = 0; j < n; j++) {
                result.add(j);
            }
            results.add(result);
        }

        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i;
                // trick -> we can move k steps all together for calculation 
                //          rather than while (counter < k) { move }
                int y = j + k;
                x += y / n;
                x = x % m;
                y = y % n;
                // trick -> this is for space O(1) excluding return structure space
                results.get(x).set(y, grid[i][j]);
            }
        }
        return results;
    }
}
