class Solution {
  // trick -> quick select = binary search + two pointer
  public int[][] kClosest(int[][] points, int K) {
    random(points);
    int l = 0;
    int r = points.length - 1;
    // trick -> it's like binary search, but we used index here to control move left or right
    while (l < r) {
        int index = partition(points, l, r);
        if (index == K) break;
        if (index < K) {
            l = index + 1;
        } else {
            r = index - 1;
        }
    }

    int[][] results = new int[K][2];
    for (int i = 0; i < K; i++) results[i] = points[i];
    return results;
  }

  private int partition(int[][] points, int start, int end) {
    if (start == end) return start;
    int p = end;
    int l = start - 1;
    int r = start;

    while (l < p && r < p) {
      // trick -> be careful about `equal` here
      if (getDistance(points[r]) >= getDistance(points[p])) {
        r++;
      } else if (getDistance(points[r]) < getDistance(points[p])) {
        swop(points, l + 1, r);
        l++;
        r++;
      }
    }
    swop(points, l + 1, p);
    return l + 1;
  }

  private int getDistance(int[] point) {
    // bug point -> point[0] * point[0] - point[1] * point[1];
    return point[0] * point[0] + point[1] * point[1];
  }

  private void swop(int[][] points, int i, int j) {
    int[] temp = points[i];
    points[i] = points[j];
    points[j] = temp;
  }

  private void random(int[][] points) {
    Random r = new Random();
    for (int i = 0; i < points.length; i++) {
      int randomIndex = r.nextInt(points.length);
      int[] temp = points[randomIndex];
      points[randomIndex] = points[i];
      points[i] = temp;
    }
  }
}
