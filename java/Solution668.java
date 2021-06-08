class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int h = m * n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            // trick -> we can use >= k to avoid the mid number is not in array
            //          e.g [1, 2, 2, 3, 3, 4, 6, 6, 9] and k = 7
            //          5 is not right answer cos counter (m, n, 5) > 6 but not (m, n, 5) >= 7
            if (count(m, n, mid) >= k) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int count(int m, int n, int value) {
        int counter = 0;
        // trick -> this is the most trickest part to count
        //          we use value / rowNumber to get how many values are greater
        //          values in o(n)
        for (int i = 1; i <= m; i++) counter += Math.min(n, value/i);
        return counter;
    }
}
