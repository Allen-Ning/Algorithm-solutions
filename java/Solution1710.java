class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int left = truckSize;
        int weight = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (left <= 0) break;

            int[] boxType = boxTypes[i];
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];
            if (left >= numberOfBoxes) {
                left -= numberOfBoxes;
                weight += numberOfBoxes * numberOfUnitsPerBox;
            } else {
                weight += left * numberOfUnitsPerBox;
                left = 0;
            }
        }
        return weight;
    }
}
