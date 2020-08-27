public class Solution {
    // please notice -> this is not AC and might need double check
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return helper(maze, visited, start, destination, null);
    }

    private boolean helper(int[][] maze, boolean[][] visited, int[] end, int[] current, int[] direction) {
        if (current[0] < 0 || 
            current[0] >= maze.length || 
            current[1] < 0 ||
            current[1] >= maze[0].length ||
            maze[current[0]][current[1]] == 1 ||
            visited[current[0]][current[1]]
        ) return false;

        if (current[0] == end[0] && current[1] == end[1]) return true;

        visited[current[0]][current[1]] = true;
        if (direction != null) {
            int[] next = new int[] { current[0] + direction[0], current[1] + direction[1] };
            if (helper(maze, visited, end, next, direction)) return true;
        }

        int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        for (int[] dir : dirs) {
            if (direction != null && dir[0] == direction[0] && dir[1] == direction[1]) continue;
            int[] next = new int[] { current[0] + dir[0], current[1] + dir[1] };
            if (helper(maze, visited, end, next, dir)) return true;
        }
        visited[current[0]][current[1]] = false;
        return false;
    }
}