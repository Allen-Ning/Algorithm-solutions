class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;

        int max = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < wall.size(); i++) {
          int prefix = 0;
          List<Integer> bricks = wall.get(i);
          for (int j = 0; j < bricks.size() - 1; j++) {
            prefix += bricks.get(j);
            int count = map.getOrDefault(prefix, 0) + 1;
            max = Math.max(max, count);
            map.put(prefix, count);
          }
        }
        return wall.size() - max;
    }
}
