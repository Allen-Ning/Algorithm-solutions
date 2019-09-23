class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        char[] array = s.toCharArray();

        int start = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                end = i - 1;
                while (end > start) {
                    swop(array, start, end);
                    start++;
                    end--;
                }
                start = i + 1;
            } else if (i == array.length - 1) {
                end = i;
                while (end > start) {
                    swop(array, start, end);
                    start++;
                    end--;
                }
                start = i + 1;
            }
        }
        return String.valueOf(array);
    }

    private void swop(char[] array, int start, int end) {
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
