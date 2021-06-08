class Solution {
    public String reverseStr(String s, int k) {
        if (k == 0 || k == 1) return s;

        char[] data = s.toCharArray();
        int index = 0;
        // 0 1 2 3 4 5 6 
        // a b c d e f g
        for (int i = 0; i < data.length; i++) {
            int start = i;
            int end = Math.min(start + k - 1, data.length - 1);
            while (start < end) swop(data, start++, end--);
            i += 2 * k - 1;
        }
        return new String(data);
    }
    
    private void swop(char[] data, int i, int j) {
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}