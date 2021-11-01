class Solution {
    public int minSteps(String s, String t) {
        int[] check = new int[26];
        int size = s.length();
        for (int i = 0; i < size; i++) {
            check[s.charAt(i) - 'a'] += 1;
            check[t.charAt(i) - 'a'] -= 1;
        }

        int total = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] <= 0) continue;
            total += check[i];
        }

        return total;
    }
}