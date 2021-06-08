class Solution {
    // trick -> o(n^3)
    public int numPoints(int[][] points, int r) {
        int result = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double[] p1 = new double[]{(double) points[i][0], (double) points[i][1]};
                double[] p2 = new double[]{(double) points[j][0], (double) points[j][1]};
                if (distance(p1, p2) > 2 * r) continue;

                // trick -> 2 points and a radius can find 2 circles
                double[][] centers = findCenter(r, p1, p2);
                for (int z = 0; z < centers.length; z++) {
                    double[] center = centers[z];
                    int counter = 2;
                    for (int w = 0; w < points.length; w++) {
                        if (w == i || w == j) continue;

                        double[] p3 = new double[] { (double) points[w][0], (double) points[w][1] };
                        if (distance(p3, center) <= r) counter++;
                    }
                    result = Math.max(result, counter);
                }
            }
        }
        return result;
    }

    private double distance(double[] p1, double[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    private double distanceInt(int[] p1, int[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    private double[][] findCenter(int r, double[] p1, double[] p2) {
        double x1 = p1[0];
        double y1 = p1[1];

        double x2 = p2[0];
        double y2 = p2[1];

        double m = (x2 * x2 + y2 * y2 - x1* x1 - y1 * y1) / (2 * (x2 - x1));
        double n = (y1 - y2) / (x2 - x1);

        double A = n * n + 1;
        double B = -2 * (x1 * n - m * n + y1);
        double C = y1 * y1 + (x1 - m) * (x1 - m) - r * r;

        double c1b = (-1 * B + Math.sqrt(B * B - 4 * A * C)) / (2 * A);
        double c2b = (-1 * B - Math.sqrt(B * B - 4 * A * C)) / (2 * A);

        double c1a = m + c1b * n;
        double c2a = m + c2b * n;
        return new double[][] {{c1a, c1b}, {c2a, c2b}};
    }
}