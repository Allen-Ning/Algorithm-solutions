class Solution {
  public List<String> summaryRanges(int[] nums) {
    ArrayList<String> list = new ArrayList();
    for (int i = 0; i < nums.length; i++) {
      int value = nums[i];
      while (i != nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
        i++;
      }

      if (nums[i] > value) {
        list.add(value + "->" + nums[i]);
      } else {
        list.add(nums[i] + "");
      }
    }
    return list;
  }
}
