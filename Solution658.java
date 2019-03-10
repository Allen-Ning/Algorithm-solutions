class Solution {
    // https://www.youtube.com/watch?v=3ifFNvdfjyg&t=116s
    // 0   mid  |  mid+K  n-k n
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int low = 0;
      int high = arr.length - k;
      while (low < high) {
        int mid = low + (high - low) / 2;
        if (x - arr[mid] > arr[mid + k] - x) {
          low = mid + 1;
        } else {
          high = mid;
        }
      }
      
      List<Integer> result = new ArrayList<Integer>();
      for (int i = 0; i < k; i++) {
        result.add(arr[i+ low]);
      }
      return result;
    }
}
