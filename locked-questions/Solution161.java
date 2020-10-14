public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        boolean result = false;
        if (Math.abs(lengthS - lengthT) > 1) {
            return false;
        } else if (lengthS - lengthT == 1) {
            result = compareWithDifferentLength(t, s);
        } else if (lengthT - lengthS == 1) {
            result = compareWithDifferentLength(s, t);
        } else {
            result = compareWithSameLength(t, s);
        }
        return result;
    }

    // trick -> s1 is shorter than s2
    private boolean compareWithDifferentLength(String s1, String s2) {
        int counter = 0;
        int p1 = 0;
        int p2 = 0; 
        while (p1 < s1.length()) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                counter++;
            } else {
                p1++;
            }
            p2++;
            if (counter > 1) return false; 
        }

        while (p2 < s2.length()) {
            counter++;
            p2++;
        }

        if (counter > 1) return false;
        return true;
    }

    private boolean compareWithSameLength(String s1, String s2) {
        int counter = 0;
        int p1 = 0;
        int p2 = 0; 
        while (p1 < s1.length()) {
            if (s1.charAt(p1) != s2.charAt(p2)) counter++;
            p1++;
            p2++;
            if (counter > 1) return false;
        }
        return counter == 1;
    }
}