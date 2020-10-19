public class Solution {
    public int countCornerRectangles(int[][] grid) {
        int total =  0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int counter = 0;
                for (int z = 0; z < grid[0].length; z++) {
                    if (grid[i][z] == 1 && grid[j][z] == 1) counter++;
                }
                total += counter * (counter - 1) / 2;
            }
        }
        return total;
    }
}
