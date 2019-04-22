class NumArray {
    int[] arraySum;
    public NumArray(int[] nums) {
      if (nums.length == 0) return;
      this.arraySum = new int[nums.length];
      arraySum[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        arraySum[i] = arraySum[i - 1] + nums[i];
      }
    }
    
    public int sumRange(int i, int j) {
      if (i == 0) return arraySum[j];
      return arraySum[j] - arraySum[i - 1];
    }
}
