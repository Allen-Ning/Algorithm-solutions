class Solution {
    public boolean isRobotBounded(String instructions) {
        int directionIndex = 0;
        int[] position = new int[] {0, 0};
        int[][] directions = new int[][]{{0, 1},{1, 0},{0, -1}, {-1, 0}};
        int mod = directions.length;

        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'L') {
                directionIndex -= 1;
                directionIndex = (directionIndex + mod) % mod;
            } else if (instruction == 'R') {
                directionIndex += 1;
                directionIndex = (directionIndex + mod) % mod;
            } else if (instruction == 'G') {
                position[0] += directions[directionIndex][0];
                position[1] += directions[directionIndex][1];
            }
        }

        if (directionIndex == 0 && position[0] == 0 && position[1] == 0) return true;
        if (directionIndex == 1 || directionIndex == 2 || directionIndex == 3) return true;
        return false;
    }
}