class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return false;

        int hCounter = 0;
        int vCounter = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                vCounter += 1;
            } else if (c == 'D') {
                vCounter -= 1;
            } else if (c == 'L') {
                hCounter -= 1;
            } else if (c == 'R') {
                hCounter += 1;
            }
        }
        if (hCounter == 0 && vCounter == 0) {
            return true;
        } else {
            return false;
        }
    }
}
