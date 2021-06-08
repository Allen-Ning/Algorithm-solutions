class Solution {
  // Input: [3,2,3]
  // Output: [3]

  // Input: [1,1,1,3,3,2,2,2]
  // Output: [1,2]
  public List<Integer> majorityElement(int[] nums) {
    if (nums == null) return new ArrayList();

    Integer num1 = null;
    Integer num2 = null;
    Integer counter1 = 0;
    Integer counter2 = 0;

    // first loop to run
    for (int num : nums) {
      if (num1 != null && num1 == num) {
        counter1++;
      } else if (num2 != null && num2 == num) {
        counter2++;
      } else if (num1 == null) {
        num1 = num;
        counter1++;
      } else if (num2 == null) {
        num2 = num;
        counter2++;
      }  else {
        if (--counter1 == 0) num1 = null;
        if (--counter2 == 0) num2 = null;
      }
    }
    
    // second loop to double check
    counter1 = 0;
    counter2 = 0;
    for (int num: nums) {
      if (num1 != null && num1 == num) counter1++;
      if (num2 != null && num2 == num) counter2++;
    }

    ArrayList<Integer> result = new ArrayList();
    if (nums.length < counter1 * 3) result.add(num1);
    if (nums.length < counter2  * 3) result.add(num2);
    return result;
  }
}
