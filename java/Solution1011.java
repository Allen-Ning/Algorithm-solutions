class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0 || D == 0) return 0;

        int sum = 0;
        int max = 0;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        int avg = sum / D;
        int l = Math.max(avg, max);
        int r = sum + 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (counter(weights, mid) > D) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int counter(int[] weights, int capacity) {
        int buffer = 0;
        int counter = 1;
        for (int i = 0; i < weights.length; i++) {
            if (buffer + weights[i] <= capacity) {
                buffer += weights[i];
            } else {
                buffer = weights[i];
                counter++;
            }
        }
        return counter;
    }
}
