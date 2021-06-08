// index h if h of his/her N papers have at least h citations each
class Solution {
  public int hIndex(int[] citations) {
    int start = 0;
    int end = citations.length;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (citations[mid] >= (citations.length - mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return citations.length - start;
  }
}
