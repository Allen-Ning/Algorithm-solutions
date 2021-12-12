class Solution {
    public int kthFactor(int n, int k) {
        double value = Math.sqrt(n);
        boolean isSqrt = false;
        List<Integer> list = new ArrayList();        
        for (int i = 1; i * i <= n; i++) {
            if ((double) i == value) isSqrt = true;
            if (n % i == 0) list.add(i);
        }

        int halfSize = list.size();
        int max = halfSize * 2;
        if (isSqrt) max -= 1;
        if (k > max) return -1;

        int index = -1;
        if (k <= halfSize) {
            index = k - 1;
            return list.get(index);
        } else {
            // trick -> when there is no sqrt root
            // e.g [1, 2, 3, 4, 6, 12], find k = 4
            index = halfSize - (k - halfSize);
            // trick -> when there is sqrt root
            // e.g [1, 2, 4, 8, 16], find k = 4
            if (isSqrt) index -= 1;
            return n / list.get(index);
        }
    }
}