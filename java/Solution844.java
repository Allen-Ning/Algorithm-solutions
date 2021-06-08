class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return false; 
        int p1 = S.length() - 1;
        int p2 = T.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int step = 0;
            // trick -> implementation is very trick
            while (p1 >= 0 && (S.charAt(p1) == '#' || step > 0)) {
                if (S.charAt(p1) == '#') {
                    step++;
                } else {
                    step--;
                }
                p1--;
            }
            char c1 = (p1 < 0) ? ' ' : S.charAt(p1);   

            step = 0;
            while (p2 >= 0 && (T.charAt(p2) == '#' || step > 0)) {
                if (T.charAt(p2) == '#') {
                    step++;
                } else {
                    step--;
                }
                p2--;
            }
            char c2 = (p2 < 0) ? ' ' : T.charAt(p2);
           
            if (c1 != c2) return false;

            p1--;
            p2--;
        }
        if  (p1 > 0 || p2 > 0) return false;
        return true;
    }
    
}
