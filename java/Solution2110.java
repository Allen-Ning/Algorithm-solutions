class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = prices.length;

        int prev = prices[0];
        int counter = 1;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            if (price + 1 == prev) {
                result += counter;
                counter++;
            } else {
                counter = 1;
            }

            prev = price;
        }
        return result;
    }
}