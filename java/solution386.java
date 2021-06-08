class Solution {
  private List<Integer> list;
  private int n;
  public List<Integer> lexicalOrder(int n) {
    this.list = new ArrayList();
    this.n = n;
    for (int i = 1; i <= 9; i++) {
      helper(i);
    }
    return list;
  }

  private void helper(int num) {
    if (num > n) return;
    list.add(num);

    for (int i = 0; i <= 9; i++) {
      helper(num * 10 + i);
    }
  }
}
