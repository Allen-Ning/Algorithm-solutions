public class Solution {
    public int numDistinctIslands2(int[][] grid) {
        Set<String> islands = new HashSet();
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;

                List[] current = new List[8];
                for (int z = 0; z < current.length; z++) current[z] = new ArrayList();
                helper(grid, current, i, j);

                // trick -> we need to normalize the island to know if it is an existing shape
                String[] noramlizedIslands = new String[8];
                boolean newShape = true;
                for (int z = 0; z < current.length; z++) {
                    String noramlizedIsland = normalize(current[z]);
                    if (islands.contains(noramlizedIsland)) {
                        newShape = false;
                        break;
                    }
                    noramlizedIslands[z] = noramlizedIsland;
                }

                if (newShape) {
                    for (String island : noramlizedIslands) islands.add(island);
                    result++;
                }
            }
        }
        return result;
    }

    private void helper(int[][] grid, List<int[]>[] current, int i, int j) {
        if (i < 0 ||
            i >= grid.length ||
            j < 0 ||
            j >= grid[0].length ||
            grid[i][j] == 0) return;

        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        grid[i][j] = 0;

        // trick -> this will include all posibility of combining mirrow and rotation
        int[][] mappings = new int[][] {
            {i, j},
            {i, -j},
            {-i, j},
            {-i, -j},
            {j, i},
            {j, -i},
            {-j, i},
            {-j, -i}
        };

        for (int index = 0; index < mappings.length; index++) current[index].add(new int[]{ mappings[index][0], mappings[index][1]});
        for (int[] dir : dirs) helper(grid, current, i + dir[0], j + dir[1]);
    }

    private String normalize(List<int[]> island) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(island, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] base = island.get(0);
        for (int j = 0; j < island.size(); j++) {
            sb.append((island.get(j)[0] - base[0]) + "," + (island.get(j)[1] - base[1]) + "|");
        }
        return sb.toString();
    }
}
