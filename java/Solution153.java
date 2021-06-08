public class Solution153 {

  public static void main(String[] args) {
    Solution153 s = new Solution153();
    int result1 = s.findMin(new int[] {3,4,5,1,2});
    System.out.println(result1);
  }

  public int findMin(int[] nums) {
    // 3,4,5,1,2
    // 4,5,6,7,0,1,2
    // 6 0 1 2 3 4 5

    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] < nums[high]) {
        high = mid;
      } else if (nums[mid] > nums[high]) {
        low = mid + 1;
      }
    }
    return nums[low];
  }

}
