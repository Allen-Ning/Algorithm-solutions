class Solution {
    public int totalFruit(int[] tree) {
        int l = 0;
        int r = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap();
        while (r < tree.length) {
            map.put(tree[r], map.getOrDefault(tree[r], 0) + 1);
            while (map.size() > 2) {
                int value = map.get(tree[l]) - 1;
                if (value == 0) {
                    map.remove(tree[l]);
                } else {
                    map.put(tree[l], value);
                }
                l++;
            }
            max = Math.max(r - l + 1, max);
            r++;
        }
        return max;
    }
}
