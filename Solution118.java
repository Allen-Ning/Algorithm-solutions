class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList();
    if (numRows == 0) return result;
    List<Integer> list = new ArrayList();
    list.add(1);
    result.add(list);

    for (int i = 1; i < numRows; i++) {
      List<Integer> list2 = new ArrayList();
      for (int j = 0; j <= i; j++) {
        List<Integer> aboveRow = result.get(i - 1);
        int value = 0;
        if (j - 1 >= 0) value += aboveRow.get(j - 1);
        if (j <= aboveRow.size() - 1) value += aboveRow.get(j);
        list2.add(value);
      }
      result.add(list2);
    }
    return result;
  }
}
