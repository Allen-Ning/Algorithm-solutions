class Solution {
  // quick selection template:
  // https://www.jiuzhang.com/solution/kth-largest-element
  public int[][] kClosest(int[][] points, int k) {
    if (k >= points.length)
      return points;
    quickSelect(0, points.length - 1, points, k - 1);

    int[][] results = new int[k][2];
    for (int i = 0; i < k; i++) {
      results[i] = points[i];
    }
    return results;
  }

  private int[] quickSelect(int start, int end, int[][] points, int k) {
    if (start >= end) {
      return points[k];
    }

    int left = start;
    int right = end;
    int pivot = left + (right - left) / 2;
    int pivotValue = distance(points[pivot]);

    while (left <= right) {
      while (left <= right && distance(points[left]) < pivotValue) {
        left++;
      }

      while (left <= right && distance(points[right]) > pivotValue) {
        right--;
      }

      if (left <= right) {
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
        left++;
        right--;
      }
    }

    if (k <= right) {
      return quickSelect(start, right, points, k);
    }

    if (k >= left) {
      return quickSelect(left, end, points, k);
    }

    return points[k];
  }

  private int distance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }
}