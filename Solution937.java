class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (str1, str2) -> compare(str1, str2));
        return logs;
    }

    private int compare(String str1, String str2) {
        String[] data1 = str1.split(" ");
        String[] data2 = str2.split(" ");
        String id1 = data1[0];
        String id2 = data2[0];

        String value1 = str1.substring(id1.length() + 1);
        String value2 = str2.substring(id2.length() + 1);
        boolean isDigit1 = Character.isDigit(value1.charAt(0));
        boolean isDigit2 = Character.isDigit(value2.charAt(0));
        if (!isDigit1 && isDigit2) {
            return -1;
        } else if (isDigit1 && !isDigit2) {
            return 1;
        } else if (isDigit1 && isDigit2) {
            // trick -> return 0 if we would like to keep the original order in array
            return 0;
        } else {
            int value = value1.compareTo(value2);
            return value != 0 ? value : str1.compareTo(str2);
        }
    }
}
