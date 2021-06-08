class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int modifiedIndex = 0;
        int i = 0;
        while (i < chars.length) {
            char currentChar = chars[i];
            int j = i;
            int counter = 0;
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
                counter++;
            }
            chars[modifiedIndex++] = currentChar;
            if (counter > 1) {    
                char[] values = String.valueOf(counter).toCharArray();
                for (char value : values) {
                    chars[modifiedIndex++] = value;
                }
            }
            i = j;
        }
        return modifiedIndex;
    }
}
