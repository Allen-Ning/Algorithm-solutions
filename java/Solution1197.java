class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x == 0 && y == 0) return 0;

        // bfs
        int[][] directions = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
        Set<String> isVisited = new HashSet();
        Queue<int[]> list = new LinkedList();
        list.add(new int[] {0, 0});
        isVisited.add(getKey(0, 0));

        int step = 0;
        while (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int[] current = list.poll();
                for (int[] dir : directions) {
                    int nextX = current[0] + dir[0];
                    int nextY = current[1] + dir[1];

                    // trick -> if (nextX < -2 || nextY < -2) also works here
                    //          but (nextX < -1 || nextY < -1) is a better
                    //          cos the (-2, -2) contribute the same possible visited grids as (-1, -1)
                    if (nextX < -1 || nextY < -1) continue;
                    String key = getKey(nextX, nextY);
                    if (!isVisited.add(key)) continue;
                    list.add(new int[]{nextX, nextY});
                    if (nextX == x && nextY == y) return step + 1;
                }
            }
            step++;
        }
        return -1;
    }

    private String getKey(int x, int y) {
        return x + "," + y;
    }
}