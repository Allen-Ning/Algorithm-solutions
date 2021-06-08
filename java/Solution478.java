class Solution {

    double radius;
    double x_center;
    double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        // trick ->
        // t (Math.random())-> [0, 1)
        // t * R^2 PI = r^2 PI
        // r = sqrt(t) * R
        double r = Math.sqrt(Math.random()) * radius;
        double theta = Math.random() * 2* Math.PI;
        double x = x_center + r * Math.cos(theta);
        double y = y_center + r * Math.sin(theta);
        return new double[] {x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
