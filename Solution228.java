class Solution {
  public List<String> summaryRanges(int[] nums) {
    int start = 0;
    int end = 0;
    ArrayList<String> values = new ArrayList();
    for (int i = 0; i < nums.length; i++) {
      if ( i == nums.length - 1) {
        if (i >= 1 && nums[i] == nums[i - 1] + 1) {
          end = i;
          add(nums, values, start, end);
        } else {
          end = i;
          add(nums, values, end, end);
        }
      } else {
        if (nums[i] + 1 != nums[i + 1]) {
          end = i;
          add(nums, values, start, end);
          start = i + 1;
        }
      }
    }
    return values;
  }

  private void add(int[] nums, ArrayList values, int start, int end) {
    if (end > start) {
      values.add(nums[start] + "->" +  nums[end]);
    } else {
      values.add(Integer.toString(nums[start]));
    }
  }
}
