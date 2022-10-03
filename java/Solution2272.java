class Solution {
    public int largestVariance(String s) {
        Set<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        int result = 0;
        for (char c1 : set) {
            for (char c2 : set) {
                if (c1 == c2) continue;
                result = Math.max(result, count(s, c1, c2));
            }
        }
        return result;
    }

    private int count(String s, char c1, char c2) {
        // ending with i not containg -1
        // ending with i containing -1
        int dp0 = 0;
        // trick -> if we only see 1 in s,
        //          this value is small enough to ignore those 1(s)
        int dp1 = s.length() * (-1);

        int result = dp1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == c1) {
                dp0 += 1;
                dp1 += 1;
            } else if (c == c2) {
                dp1 = Math.max(dp0 - 1, dp1 - 1);
                dp0 = 0;
            }
            result = Math.max(result, dp1);
        }
        return result;
    }
}