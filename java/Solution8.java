class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') break;
            if (c == '+') {
                i++;
                break;
            }

            if (c == '-') {
                sign = -1;
                i++;
                break;
            }

            if ((c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == '.'
            ) {
                return 0;
            }

            i++;
        }

        long result = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c > '9' || c < '0') break;

            // notice: implementation trick
            // cannot do value = num * 10 + c - '0';
            // num * 10 may lead to overflow before assigning to long value
            result = result * 10 + (long)(c - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result  * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        result = result * sign;
        return (int)result;
    }
}