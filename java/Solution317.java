public class Solution {
    public int shortestDistance(int[][] grid) {
        // find all the houses
        List<Element> houses = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    houses.add(new Element(i, j, 0));
                }
            }
        }

        int numOfHouse = houses.size();
        int[][] counter = new int[grid.length][grid[0].length];
        int[][] distances = new int[grid.length][grid[0].length];
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < houses.size(); i++) {
            Element house = houses.get(i);
            result = Math.min(result, bfs(grid, counter, distances, dirs, numOfHouse, house));
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int bfs(int[][] grid, int[][] counter, int[][] distances, int[][] dirs, int numOfHouse, Element house) {
        int result = Integer.MAX_VALUE;
        boolean[][] check = new boolean[grid.length][grid[0].length];
        Queue<Element> lands = new LinkedList();
        lands.add(house);
        check[house.x][house.y] = true;

        while (lands.size() > 0) {
            int size = lands.size();
            for (int j = 0; j < size; j++) {
                Element current = lands.poll();
                for (int[] dir : dirs) {
                    int nextX = current.x + dir[0];
                    int nextY = current.y + dir[1];
                    int distance = current.distance + 1;

                    if (nextX < 0 ||
                        nextX >= grid.length ||
                        nextY < 0 ||
                        nextY >= grid[0].length ||
                        grid[nextX][nextY] >= 1 ||
                        check[nextX][nextY]
                    ) continue;

                    Element next = new Element(nextX, nextY, distance);
                    check[nextX][nextY] = true;
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
                    lands.offer(next);
                }
            }
        }
        return result;
    }

    class Element {
        int x;
        int y;
        int distance;

        public Element(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}