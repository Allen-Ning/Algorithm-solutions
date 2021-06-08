// Example 1
// 1 2 3 4 5 6 7 8 9 10  
// 2 4 6 8 10
// 4 8 
// 8

// Example 2
// 1 2 3 4 5 6 7 8 9
// 2 4 6 8
// 2 6
// 6

class Solution {
  public int lastRemaining(int n) {
    int remaining = n;
    boolean isLeftToRight = true;
    int step = 1;
    int head = 1;
    while (remaining > 1) {
      if (isLeftToRight || remaining % 2 != 0) {
        head += step;
      }
      isLeftToRight = !isLeftToRight;
      step *= 2;
      remaining /= 2;
    }
    return head;
  }
}
