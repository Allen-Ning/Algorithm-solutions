class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // trick -> use int[] instead of hashmap will make implement much easier
        // please notice What if this constraint 0 <= arr1[i], arr2[i] <= 1000 doesn't exist?
        // Use TreeMap
        int[] counters = new int[10001];

        for (int value : arr1) counters[value] += 1;
        int[] results = new int[arr1.length];
        int index = 0;
        for (int value : arr2) {
            while (counters[value]-- > 0) results[index++] = value;
        }

        for (int i = 0; i < counters.length; i++) {
            while (counters[i]-- > 0) results[index++] = i;
        }
        return results;
    }
}
