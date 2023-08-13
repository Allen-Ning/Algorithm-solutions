class Solution {
    public boolean backspaceCompare(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        int p1 = s.length() - 1;
        int p2 = t.length() - 1;

        while (p1 >= 0 && p2 >= 0) {
            p1 = next(s, p1);
            p2 = next(t, p2);
            if (p1 < 0 && p2 < 0) return true;
            if (p1 < 0 || p2 < 0) break;

            if (s.charAt(p1) != t.charAt(p2)) return false;
            p1--;
            p2--;
        }

        // trick -> deal with corner case
        //          e.g ["nzp#o#g", "b#nzp#o#g"]
        if (p1 >= 0) p1 = next(s, p1);
        if (p2 >= 0) p2 = next(t, p2);

        if (p1 >= 0 || p2 >= 0) return false;
        return true;
    }

    private int next(String str, int index) {
        int counter = 0;
        for (int i = index; i >=0; i--) {
            char c = str.charAt(i);
            if (c == '#') {
                counter++;
                continue;
            }

            if (counter > 0) {
                counter--;
                continue;
            }
            return i;
        }
        return -1;
    }
}