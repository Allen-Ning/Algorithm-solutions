class Solution {
    public String nearestPalindromic(String n) {
        long nLong = Long.valueOf(n);
        if (nLong <= 10) return (nLong - 1) + "";

        long[] results = new long[] { Long.MAX_VALUE };

        int length = n.length();

        // trick -> if the size of str changed, which means the closest palindron wil be 10..01 or 9..9
        // 9...9
        Long min = (long) Math.pow(10, n.length() - 1) - 1;
        updateResult(results, nLong, min);

        // 100..001
        Long max = (long) Math.pow(10, n.length()) + 1;
        updateResult(results, nLong, max);

        // n + 1
        // n - 1
        // 23456
        // trick -> try 233, 234, 235 as left part and then get the right part
        //          if mid num is 0 or 9, then we have to cal the carrier
        add(results, nLong, n, 0);
        StringBuilder sb = new StringBuilder(n);
        int mid = (n.length() - 1) / 2;
        char c = n.charAt(mid);
        if ('1' <= c  && c <= '8') {
            sb.setCharAt(mid, (char) (c - 1));
            add(results, nLong, sb.toString(), 0);

            sb.setCharAt(mid, (char) (c + 1));
            add(results, nLong, sb.toString(), 0);
        } else if (c == '0') {
            sb.setCharAt(mid, (char) (c + 1));
            add(results, nLong, sb.toString(), 0);

            sb.setCharAt(mid, '9');
            add(results, nLong, sb.toString(), -1);
        } else if (c == '9') {
            sb.setCharAt(mid, '0');
            add(results, nLong, sb.toString(), 1);

            sb.setCharAt(mid, (char) (c - 1));
            add(results, nLong, sb.toString(), 0);
        }
        return String.valueOf(results[0]);
    }

    private void updateResult(long[] results, long nlong, long num) {
        if (num == nlong) return;

        if (Math.abs(num - nlong) < Math.abs(results[0] - nlong) ||
            (Math.abs(num - nlong) == Math.abs(results[0] - nlong) && num < results[0])
        ) results[0] = num;
    }

    private String modify(String str, int carrier) {
        StringBuilder sb = new StringBuilder(str);
        int mid = (str.length() - 1) / 2;
        // resovle carrier
        int carry = carrier;
        for (int i = mid - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c + carry > '9') {
                sb.setCharAt(i, '0');
                carry = 1;
            } else if (c + carry < '0') {
                sb.setCharAt(i, '9');
                carry = -1;
            } else {
                sb.setCharAt(i, (char) (c + carry));
                carry = 0;
            }
        }
        // trick -> the size of str changed, which means the closest palindron wil be 10..01 or 9..9
        //          those value has been added in at the beginning of the code
        if (carry == 1) return "";
        if (sb.charAt(0) == '0') return "";
        return sb.toString();
    }

    private void add(long[] results, long nLong, String str, int carrier) {
        String modifiedStr = modify(str, carrier);
        if (modifiedStr.length() == 0) return;

        StringBuilder sb = new StringBuilder(modifiedStr);
        int mid = (sb.length() - 1) / 2;
        int l = -1;
        int h = -1;
        if (sb.length() % 2 == 0) {
            // "1222"
            l = mid;
            h = mid + 1;
        } else {
            // "122"
            l = mid - 1;
            h = mid + 1;
        }
        while (l >= 0 && h < sb.length()) sb.setCharAt(h++, sb.charAt(l--));
        updateResult(results, nLong, Long.valueOf(sb.toString()));
    }
}