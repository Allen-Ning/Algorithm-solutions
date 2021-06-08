// Please notice "\\."
// Please notice "\\."
class Solution {
    public int compareVersion(String version1, String version2) {
        // 7.5.2.4,
        // 7.5.3
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");

        int length = Math.max(array1.length, array2.length);
        for (int i = 0; i < length; i++) {
            int value1 = i < array1.length ? Integer.valueOf(array1[i]) : 0;
            int value2 = i < array2.length ? Integer.valueOf(array2[i]) : 0;
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
        }
        return 0;
    }
}
