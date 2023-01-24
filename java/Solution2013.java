class DetectSquares {

    int[][] count;
    List<int[]> points;

    public DetectSquares() {
        this.count = new int[1001][1001];
        this.points = new ArrayList();
    }

    public void add(int[] point) {
        count[point[0]][point[1]] += 1;
        points.add(point);
    }

    public int count(int[] point) {
        int result = 0;
        for (int[] one : points) {
            int width = Math.abs(one[0] - point[0]);
            int height = Math.abs(one[1] - point[1]);

            if (width == 0 || height == 0 || width != height) continue;

            // trick -> interesting fact - no matter where is an existing point (aka one) and a point,
            //          another two points coordinator will always be [(point.x, one.y), (one.x, point.y)]
            int x1 = point[0];
            int y1 = one[1];

            int x2 = one[0];
            int y2 = point[1];

            if (count[x1][y1] > 0 && count[x2][y2] > 0) result += count[x1][y1] * count[x2][y2];
        }
        return result;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */