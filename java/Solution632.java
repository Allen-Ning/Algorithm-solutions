class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
      int[] result = new int[2];
      if (nums == null || nums.size() == 0) return result;

      int size = nums.size();
      int[] indexes = new int[nums.size()];
      PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

      int max = 0;
      for (int i = 0; i < indexes.length; i++) {
          queue.offer(new int[] {i, nums.get(i).get(indexes[0])});
          max = Math.max(max, nums.get(i).get(indexes[0]));
      }

      int range = max - queue.peek()[1];
      result = new int[] {queue.peek()[1], max};
      int counter = 1;
      while (queue.size() > 0) {
        int[] element = queue.poll();
        int min = element[1];
        if (max - min < range) {
            result = new int[] {min, max};
            range = max - min;
        }

        int rowNum = element[0];
        indexes[rowNum] += 1;

        // trick -> we need to be careful about this if any of the array reaching ends
        // we don't need to do any check further cos we always remove the smallest one
        if (indexes[rowNum] >= nums.get(rowNum).size()) break;
        int newValue = nums.get(rowNum).get(indexes[rowNum]);

        queue.offer(new int[] {rowNum, newValue});
        max = Math.max(max, newValue);
        counter++;
      }
      return result;
    }
}
