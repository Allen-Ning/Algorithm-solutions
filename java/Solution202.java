import java.util.HashSet;

public class Solution202 {

  private HashSet<Integer> s = new HashSet<Integer>();

  public static void main(String args) {

  }

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
}
