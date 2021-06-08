class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;

        int index = 0;
        int sign = 1;
        int num = 0;
        boolean started = false;

        // check the sign seperate
        char firtLetter = str.charAt(0);
        if (firtLetter == '-') {
            sign = -1;
            index++;
        } else if (firtLetter == '+') {
            index++;
        }

        while (index < str.length()) {
            char c = str.charAt(index);
            if (c - '0' >= 0 && '9' - c >= 0) {
                // notice: implementation trick
                // cannot do value = num * 10 + c - '0';
                // num * 10 may lead to overflow before assigning to long value
                long value = num;
                value = value * 10 + c - '0';
                if (value * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (value * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                num = num * 10 + c - '0';
                started = true;
            } else {
                return started ? sign * num : 0;
            }
            index++;
        }
        return sign * num;
    }
}
