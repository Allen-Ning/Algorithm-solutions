class Solution136 {
    public static void main(String[] args) {
      Solution136 s = new Solution136();
      int result = s.singleNumber(new int[]{1,1,2,2,3});
      System.out.println(result);
    }

    public int singleNumber(int[] nums) {
      int result = 0;
      for (int num: nums) {
        result ^= num;
      }
      return result;
    }
}
