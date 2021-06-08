class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap();
        int result = 0;
        for (int[] dominoe : dominoes) {
            // trick -> after we build the key, we can put all the same key dominoe together
            int key = Math.max(dominoe[0], dominoe[1]) * 10 + Math.min(dominoe[0], dominoe[1]);

            // trick -> this is a small programing trick to avoid math calucate C(n)2
            int counter = map.getOrDefault(key, 0);
            result += counter;
            map.put(key, counter + 1);
        }
        return result;
    }
}
