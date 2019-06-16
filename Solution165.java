class Solution {
    public int compareVersion(String version1, String version2) {
        // 7.5.2.4, 
        // 7.5.3        
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");

        int length = (array1.length >= array2.length ? array2.length : array1.length);
        for (int i = 0; i < length; i++) {
            int value1 = Integer.valueOf(array1[i]);
            int value2 = Integer.valueOf(array2[i]);
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
        }

        if (array1.length == array2.length) {
            return 0;
        } else if (array1.length > array2.length) {
            int i = array2.length;
            while(i < array1.length) {
                if (Integer.valueOf(array1[i]) > 0) return 1; 
                i++;
            }
            return 0;
        } else {
            int i = array1.length;
            while(i < array2.length) {
                if (Integer.valueOf(array2[i]) > 0) return -1; 
                i++;
            }
            return 0;
        }
    }
}
