import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int num = Math.abs(nums[i]);
      int modifiedIndex = num - 1;
      if (nums[modifiedIndex] > 0) {
        nums[modifiedIndex] = -nums[modifiedIndex];
      } else {
        result.add(num);
      }
    }
    return result;
  }
}
