class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        if (S == null || S.length() == 0 || shifts == null || shifts.length == 0) return S;

        // trick -> be careful about integer overflow
        //          we can use the % 26 first to avoid using long for saving
        shifts[shifts.length - 1] %= 26;
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i + 1] + shifts[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            long step = (S.charAt(i) - 'a' + shifts[i]) % 26;
            char c = (char) (step + 'a');
            sb.append(c);
        }
        return sb.toString();
    }
}