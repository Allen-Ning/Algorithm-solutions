public class Solution {
    public int shortestDistance(int[][] grid) {
        // find all the houses
        Queue<Element> houses = new LinkedList();
        List<int[]> points = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    houses.add(new Element(i, j, houses.size(), 0));
                    points.add(new int[] {i, j});
                }
            }
        }

        int numOfHouse = houses.size();
        boolean[][][] check = new boolean[houses.size()][grid.length][grid[0].length];
        int[][] counter = new int[grid.length][grid[0].length];
        int[][] distances = new int[grid.length][grid[0].length];
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result = Integer.MAX_VALUE;
        while (houses.size() > 0) {
            int size = houses.size();
            for (int i = 0; i < size; i++) {
                Element current = houses.poll();
                for (int[] dir : dirs) {
                    int nextX = current.x + dir[0];
                    int nextY = current.y + dir[1];
                    int id = current.id;
                    int distance = current.distance + 1;

                    if (nextX < 0 ||
                        nextX >= grid.length ||
                        nextY < 0 ||
                        nextY >= grid[0].length ||
                        grid[nextX][nextY] >= 1 ||
                        check[id][nextX][nextY]
                    ) continue;

                    Element next = new Element(nextX, nextY, id, distance);
                    check[id][nextX][nextY] = true;
                    counter[nextX][nextY]++;
                    distances[nextX][nextY] += distance;
                    // trick -> the first time satisfies this condition (counter[nextX][nextY] == numOfHouse) might not be the best result
                    //          have to compare all the  possible solutions
                    //          e.g. 1 0 0 0 0
                    //               1 s 0 0 0
                    //               0 0 x 0 0
                    //               0 0 0 0 0
                    //               0 0 0 0 1
                    //          this first meeting point x, distance migth be around 3 + 4 + 4 = 11
                    //          but distance s is btter than x, and s is around 1 + 2 + 6 = 9
                    if (counter[nextX][nextY] == numOfHouse) result = Math.min(result, distances[nextX][nextY]);
                    houses.offer(next);
                }
            }
        }
        return result;
    }

    class Element {
        int x;
        int y;
        int id;
        int distance;

        public Element(int x, int y, int id, int distance) {
            this.x = x;
            this.y = y;
            this.id = id;
            this.distance = distance;
        }
    }
}