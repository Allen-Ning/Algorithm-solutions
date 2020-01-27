class Solution {

  public int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  private int mergeSort(int[] nums, int l, int r) {
    if (l >= r) return 0;
    int counter = 0;
    int mid = l + (r - l) / 2;

    counter += mergeSort(nums, l, mid);
    counter += mergeSort(nums, mid + 1, r);
    counter += merge(nums, l, mid, r);
    return counter;
  }

  private int merge(int[] nums, int l, int mid, int r) {
    int counter = 0;
    int[] values = new int[r - l + 1];

    int p1 = l;
    int p2 = mid + 1;
    int index = 0;

    // trick -> this is nice way to get the counter in o(n)
    while (p1 <= mid && p2 <= r) {
      // 0   1    2  3   4
      // p1          p2
      // [1, 16, 18] [0, 1]
      // mid + 1 - p1 = 3 - 0 = 3
      if ((long) nums[p1] > (long) 2 * nums[p2]) {
          counter += mid + 1 - p1;
          p2++;
      } else {
          p1++;
      }
    }

    p1 = l;
    p2 = mid + 1;
    while (p1 <= mid && p2 <= r) {
      values[index++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
    }

    while (p1 <= mid) values[index++] = nums[p1++];

    while (p2 <= r) values[index++] = nums[p2++];

    for (int i = l; i <= r; i++) nums[i] = values[i - l];
    return counter;
  }
}
