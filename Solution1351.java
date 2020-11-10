class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            result += (grid[i].length - binarySearch(grid[i]));
        }
        return result;
    }

    private int binarySearch(int[] grid) {
        int l = 0;
        int h = grid.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (grid[mid] >= 0) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return  l;
    }
}
