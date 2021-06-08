public class Solution {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        int l = 0;
        int h = num.length() - 1;
        // 0 1 2 3 4 5 6 7 8 9
        Set<Character> set = new HashSet();
        set.add('1');
        set.add('8');
        set.add('0');

        while (l < h) {
            char c1 = num.charAt(l);
            char c2 = num.charAt(h);
            if (c1 == c2 || (c1 == '6' && c2 == '9') || (c1 == '9' && c2 == '6')) {
                l++;
                h--;
                continue;
            }
            return false;
        }

        return l == h ? set.contains(num.charAt(l)) :true;
    }
}