public class Solution201 {

  public static void main(String[] args) {
    Solution201 s = new Solution201();
    int result = s.rangeBitwiseAnd(5, 7);
    System.out.println(result);
  
  }
  

  public int rangeBitwiseAnd(int m, int n) {
    int i = 0;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      i++;
    }
    return m << i;
  }
}

