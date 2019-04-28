class Solution {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) return "";

    String[] numStringArray = new String[nums.length];
    for (int i = 0; i < numStringArray.length; i++) {
      numStringArray[i] = String.valueOf(nums[i]);
    }
    
    String[] sortedNums = sort(numStringArray);
    if (sortedNums[0].equals("0")) return "0";
    StringBuilder str = new StringBuilder();
    for (String num: sortedNums) {
      str.append(num);
    }
    return str.toString();
  }
  
  // [30, 3]
  // num1 3
  // num2 30
  // concat 1 = 303
  // concat 2 =  330
  // -1
  // [3, 30]

  // [3, 30]
  // num1 30
  // num2 3
  // concat 1 = 330
  // concat 2 = 303
  // 1
  private String[] sort(String[] nums) {
    Arrays.sort(nums, new Comparator<String>() {
      @Override
      public int compare(String num1, String num2) {
        String concat1 = num2 + num1;
        String concat2 = num1 + num2;
        return concat1.compareTo(concat2);
      }
    });
    return nums;
  }
}
