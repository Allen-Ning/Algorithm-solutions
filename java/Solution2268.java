class Solution {
    public int minimumKeypresses(String s) {
        Integer[] rank = new Integer[26];
        Arrays.fill(rank, 0);
        for (int i = 0; i < s.length(); i++) {
            rank[s.charAt(i) - 'a'] += 1;
        }

        Arrays.sort(rank, (e1, e2) -> e2 - e1);
        int result = 0;
        for (int i = 0; i < rank.length; i++) {
            result += rank[i] * (i / 9 + 1);
        }
        return result;
    }
}