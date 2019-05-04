class Solution {
  
  int[] nums;
  public Solution(int[] nums) {
    this.nums = nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return this.nums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] shuffledNums = nums.clone();
    Random r = new Random();
    for (int i = shuffledNums.length - 1; i > 0; i--) {
      int j = r.nextInt(i + 1);
      swop(shuffledNums, i, j);
    }
    return shuffledNums;
  }
  
  private void swop(int nums[], int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
