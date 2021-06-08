class Solution {
  public int hIndex(int[] citations) {
    int[] countCitations = new int[citations.length + 1];
    for (int citation: citations) {
      if (citation > countCitations.length - 1) {
         countCitations[countCitations.length - 1] += 1;
      } else {
        countCitations[citation] += 1;
      }
    }
    int count = 0;
    for (int i = countCitations.length - 1; i >= 0; i--) {
      count += countCitations[i];
      if (count >= i) return i;
    }
    return 0;
  }
}
