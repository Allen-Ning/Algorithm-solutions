class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
        int[] buckets = new int[26];
        int windowSize = s1.length();
        HashSet<Character> set = new HashSet();

        for (int i = 0; i < s1.length(); i++) {
            buckets[s1.charAt(i) - 'a'] += -1;
            set.add(s1.charAt(i));
        }

        int total = set.size();
        int index = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) {
                index = s2.charAt(i) - 'a';
                buckets[index] += 1;
                if (buckets[index] == 0) {
                    total--;
                } else if (buckets[index] == 1) {
                    total++;
                }
            }

            if (i >= windowSize && set.contains(s2.charAt(i - windowSize))) {
                index = s2.charAt(i - windowSize) - 'a';
                buckets[index] -= 1;
                if (buckets[index] == 0) {
                    total--;
                } else if (buckets[index] == -1) {
                    total++;
                }
            }

            if (total == 0) return true;
        }
        return false;
    }
}
