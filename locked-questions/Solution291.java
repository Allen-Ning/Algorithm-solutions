public class Solution {

    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap();
        Set<String> set = new HashSet();
        return helper(map, set, pattern, 0, str, 0);
    }

    private boolean helper(Map<Character, String> map, Set<String> set, String pattern, int p1, String str, int p2) {
        // trick -> this means if all chars in str are chekced,
        //          if still chars in pattern is not mapped -> return false
        //          if all chars in pattern are mapped -> return true
        if (p2 >= str.length()) return p1 == pattern.length() ? true : false;

        // trick -> this means all chars in pattern are mapped. But there are stil some chars in str not checked -> return false
        if (p1 == pattern.length()) return false;

        char c = pattern.charAt(p1);
        String matched = map.get(c);
        if (matched == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = p2; i < str.length(); i++) {
                sb.append(str.charAt(i));
                matched = sb.toString();
                // trick -> this is to avoid same string mapped to multiple chars in pattern
                if (set.contains(matched)) continue;

                set.add(matched);
                map.put(c, matched);
                if (helper(map, set, pattern, p1 + 1, str, p2 + matched.length())) return true;
                map.remove(c);
                set.remove(matched);
            }
            return false;
        } else {
            return check(matched, str, p2) ? helper(map, set, pattern, p1 + 1, str, p2 + matched.length()) : false;
        }
    }

    private boolean check(String matched, String str, int i) {
        int size = matched.length();
        int index = 0;
        if (i + size > str.length()) return false;
        while (index < size) {
            if (matched.charAt(index) != str.charAt(i + index)) return false;
            index++;
        }
        return true;
    }
}