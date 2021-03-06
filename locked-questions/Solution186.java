public class Solution {
    public char[] reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);

        int start = 0;
        int end = 0;
        while (end < str.length) {
            if (str[end] != ' ') {
                end++;
                continue;
            }

            reverse(str, start, end - 1);
            start = end + 1;
            end++;
        }
        // trick -> this is to swop for the last word(which also needs to be handled)
        reverse(str, start, end - 1);
        return str;
    }
    
    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}
