class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] counters = new int[10001];
        int maxNum = -1;
        int maxCounter = 0;
        for (int num : barcodes) {
            counters[num] += 1;
            if (counters[num] > maxCounter) {
                maxNum = num;
                maxCounter = counters[num];
            }
        }

        int[] results = new int[barcodes.length];

        // fill the max
        int index = 0;
        while (counters[maxNum] > 0) {
            results[index] = maxNum;
            index += 2;
            counters[maxNum] -= 1;
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == 0) continue;
            while (counters[i]-- > 0) {
                // trick -> reset the index if even is all filled
                if (index >= results.length) index = 1;
                results[index] = i;
                index += 2;
            }
        }
        return results;
    }
}
