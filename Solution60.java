class Solution {

  public String getPermutation(int n, int k) {

    ArrayList<Integer> list = new ArrayList();
    int total = 1;
    for (int i = 1; i <= n; i++) {
      list.add(i);
      total *= i;
    }

    String res = "";
    k -= 1;
    while (list.size() > 0) {
      if (list.size() == 1) {
        res += list.get(0);
        break;
      }
      int block = total / n;
      int index = k / block;
      int offset = k % block;

      res += String.valueOf(list.get(index));
      list.remove(index);
      total = block;
      k = offset;
      n -= 1;
    }

    return res;
  }
}
