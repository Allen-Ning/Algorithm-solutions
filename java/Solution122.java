class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int nonSellable = 0;
        int sellable = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            // initialize
            if (i == 0) {
                nonSellable = 0;
                sellable = -price; 
            } else {
                int preNonSellable = nonSellable;
                int preSellable = sellable;
                nonSellable = Math.max(preNonSellable, price + preSellable);
                sellable = Math.max(preNonSellable - price, Math.max(preSellable, preSellable - price));
            }
        }
        return Math.max(nonSellable, sellable);
    }
}
