class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    HashMap<Integer, Integer> values = new HashMap();
    for (int num : nums) values.put(num, 1);

    int result = 0;
    for (int num : nums) {
      if (values.containsKey(num - 1)) continue;

      int nextNum = num;
      while (values.containsKey(nextNum)) {
        nextNum++;
      }
      result = Math.max(result, nextNum - num);
    }
    return result;
  }
}
