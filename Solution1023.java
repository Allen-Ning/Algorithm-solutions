class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> results = new ArrayList();
        for (String query : queries) results.add(check(query, pattern));
        return results;
    }

    private boolean check(String query, String pattern) {
        if (query.length() < pattern.length()) return false;
        int j = 0;
        for (int i = 0; i < query.length(); i++) {
            char c = query.charAt(i);
            if (j < pattern.length() && c == pattern.charAt(j)) {
                j++;
            } else if (query.charAt(i) < 'a' || query.charAt(i) > 'z') {
                return false;
            }
        }
        return j == pattern.length();
    }
}
