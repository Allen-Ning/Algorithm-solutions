class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> set = new TreeSet();
        for (int value : arr2) set.add(value);

        int counter = 0;
        for (int value : arr1) {
            Integer lowValue = set.floor(value);
            Integer highValue = set.ceiling(value);
            if ((lowValue != null && Math.abs(lowValue - value) <= d) ||
                (highValue != null && Math.abs(highValue - value) <= d)) continue;
            counter++;
        }
        return counter++;
    }
}
