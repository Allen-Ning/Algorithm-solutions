class Solution {
    public int missingNumber(int[] arr) {
        int value = arr[arr.length - 1] - arr[0];
        int slot = arr.length;
        int diff = value / slot;

        if (diff == 0) return arr[0];

        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int current = prev + diff;

            if (current != arr[i]) return current;
            prev = current;
        }

        return -1;
    }
}