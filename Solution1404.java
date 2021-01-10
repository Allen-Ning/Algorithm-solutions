class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int counter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            // trick -> when i = 0, s.charAt(i) must be 1
            //          e.g 10000 (can break here when i = 0)
            //              11000 (cannot break here cos carry is 1)
            if (i == 0 && carry == 0) break;

            if (s.charAt(i) == '0' && carry == 0) {
                counter++;
                carry = 0;
            } else if (s.charAt(i) == '0' && carry == 1) {
                counter += 2;
                carry = 1;
            } else if (s.charAt(i) == '1' && carry == 0) {
                counter += 2;
                carry = 1;
            } else if (s.charAt(i) == '1' && carry == 1) {
                counter++;
                carry = 1;
            }
        }
        return counter;
    }
}
