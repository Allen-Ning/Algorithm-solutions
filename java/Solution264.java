class Solution {
  public int nthUglyNumber(int n) {
    int index2 = 0, index3 = 0, index5 = 0;
    int nextNumberMutiplyBy2 = 2, nextNumberMutiplyBy3 = 3, nextNumberMutiplyBy5 = 5;
    int[] addedNumber = new int[n];
    addedNumber[0] = 1;
    for (int i = 1; i < n; i++) {
      int nextAddedNumber = Math.min(Math.min(nextNumberMutiplyBy2, nextNumberMutiplyBy3), nextNumberMutiplyBy5);
      addedNumber[i] = nextAddedNumber;
      if (nextAddedNumber == nextNumberMutiplyBy2) {
        nextNumberMutiplyBy2 = 2 * addedNumber[++index2];
      }
      if (nextAddedNumber == nextNumberMutiplyBy3) {
        nextNumberMutiplyBy3 = 3 * addedNumber[++index3];
      }
      if (nextAddedNumber == nextNumberMutiplyBy5) {
        nextNumberMutiplyBy5 = 5 * addedNumber[++index5];
      }
    }
    return addedNumber[n -1];
  }
}
