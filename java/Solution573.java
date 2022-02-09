class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0;
        int distance = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            sum += 2 * getDistance(tree, nut);
            distance = Math.min(distance, getDistance(squirrel, nut) - getDistance(tree, nut));
        }
        return sum + distance;
    }

    private int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}