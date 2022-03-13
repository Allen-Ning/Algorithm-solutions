class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            result = Math.max(result, price - min);
        }
        return result;
    }
}