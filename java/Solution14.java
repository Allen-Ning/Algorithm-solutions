class Solution {
    /**
     * the average length of per string is M
     * time complexity is O(M * N log (N) + M)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];

        StringBuilder sb = new StringBuilder();
        int min =  Math.min(start.length(), end.length());
        for (int i = 0; i < min; i++) {
            char c = start.charAt(i);
            if (c != end.charAt(i)) break;

            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * the average length of per string is M
     * time complexity is O(M * N)
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1) return strs[0];

        int index = 0;
        StringBuilder sb = new StringBuilder();
        String firstStr = strs[0];
        int length = firstStr.length();

        while (index < length) {
            char c = firstStr.charAt(index);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (index >= str.length()) return sb.toString();
                if (str.charAt(index) != c) return sb.toString();
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
}