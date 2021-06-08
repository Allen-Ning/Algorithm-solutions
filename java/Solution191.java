public class Solution191 {
  public static void main(String[] args) {
    Solution191 s = new Solution191();
    int val = s.hammingWeight(11);
    System.out.println(val);
  }

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      int value = n >> i;
      int newValue = value & 1;
      if (newValue == 1) count++;
    }
    return count;
  }
}
