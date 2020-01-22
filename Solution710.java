class Solution {
  // e.g.   0 (1) | (2) 3 -> [0, 4) num = 4
  // after  0 (1) | (2) 3
  //           |        |
  //           |--------|
  // newN will be 4 - 2 = 2

  int N;
  int newN;
  Map<Integer, Integer> map;
  Random random;

  public Solution(int N, int[] blacklist) {
    this.N = N;
    this.map = new HashMap();
    int size = blacklist.length;
    this.newN = N - size;
    this.random = new Random();

    for (int i = 0; i < blacklist.length; i++) map.put(blacklist[i], -1);

    int j = newN;

    // trick -> we only need to loop through the blacklist
    for (int value : blacklist) {
        // trick -> we only need to care about the value in blacklist which is less than newN
        if (value >= newN) continue;
        while (map.containsKey(j)) j++;
        map.put(value, j++);
    }
  }

  public int pick() {
    // trick -> after remap we only need to care about part of array
    int num = random.nextInt(newN);
    return map.containsKey(num) ? map.get(num) : num;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
