class Solution {
  public int[] twoSum(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      int lookupNumber = target - numbers[i];

      // binary search
      int left = 0;
      int right = numbers.length;
      while (left < right) {
        int mid = left + (right - left) / 2;
          if (numbers[mid] == lookupNumber) {
          return (i < mid) ? new int[] {i + 1, mid + 1} : new int[] {mid + 1, i + 1};
        }
        if (numbers[mid] > lookupNumber) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
    }
    return null;
  }
}
