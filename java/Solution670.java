class Solution {
    public int maximumSwap(int num) {
        char[] str = (num + "").toCharArray();
        int[] buckets = new int[10];

        for (int i = 0; i < str.length; i++) buckets[str[i] - '0'] = i;

        for (int i = 0; i < str.length; i++) {
            for (int j = buckets.length - 1; j >= 0; j--) {
                if (buckets[j] > i && str[i] < (j + '0')) {
                    char temp = str[i];
                    str[i] = str[buckets[j]];
                    str[buckets[j]] = temp;
                    // trick -> convert char[] -> string
                    return Integer.valueOf(String.valueOf(str));
                }
            }
        }
        return num;
    }
}
