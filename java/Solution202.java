import java.util.HashSet;

public class Solution202 {

  private HashSet<Integer> s = new HashSet<Integer>();

  public boolean isHappy(int n) {
    int result = 0;

    while (true) {
      int remain = n % 10;
      n = n / 10; 
      result += remain * remain;

      if (n == 0) {
        if (s.contains(result)) {
          return false;
        } else if (result == 1) {
          return true;
        } else {
          s.add(result);
          n = result;
          result = 0;
        }
      }
    }
  }

  // Best solution - FloydCycleDetection
  public boolean isHappy2(int n) {
       int slow = n;
       int fast = n;
       while (true) {
           slow = next(slow);
           fast = next(next(fast));
           if (slow == fast) break;
       }
       return slow == 1;
   }

   private int next(int n) {
       int result = 0;
       while (n > 0) {
           int value = n % 10;
           result += value * value;
           n /= 10;
       }
       return result;
   }
}
