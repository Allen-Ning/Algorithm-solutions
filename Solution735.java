class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> s = new Stack();

    for (int one : asteroids) {
      if (s.isEmpty() || one > 0) {
        s.push(one);
        continue;
      }

      int prev = s.peek();
      while (one < 0 && prev > 0 && Math.abs(one) > prev) {
        s.pop();

        if (s.isEmpty()) {
          s.push(one);
          prev = 0;
        } else {
          prev = s.peek();
        }
      }

      if (one < 0 && prev > 0 && Math.abs(one) == prev) {
        s.pop();
      }

      if (prev < 0 && one < 0) s.push(one);
    }

    int[] results = new int[s.size()];
    int i = results.length - 1;
    while (!s.isEmpty()) {
      results[i] = s.pop();
      i--;
    }
    return results;
  }
}
