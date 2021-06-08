class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) return "";
        String lower = paragraph.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else {
                sb.append(" ");
            }
        }

        HashSet<String> set = new HashSet();
        for (String each : banned) set.add(each);
        String filteredStr = sb.toString();
        String[] data = filteredStr.split(" ");
        HashMap<String, Integer> map = new HashMap();
        int maxCount = 0;
        String MaxWord = "";
        for (String word : data) {
            String key = word.trim();
            if (key.length() ==  0 || set.contains(key)) continue;
            int value = map.getOrDefault(key, 0) + 1;
            map.put(key, value);
            if (value > maxCount) {
                MaxWord = word;
                maxCount = value;
            }
        }
        return MaxWord;
    }
}
