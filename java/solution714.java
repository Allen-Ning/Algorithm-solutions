class Solution {
    //        i
    // [1, 3, 2, 8, 4, 9]
    public int maxProfit(int[] prices, int fee) {
        // trick -> one dimension dp quesiton with `two state`
        //          linear scan
        int[] buyable = new int[prices.length];
        int[] sellable = new int[prices.length];

        buyable[0] = 0;
        sellable[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buyable[i] = Math.max(sellable[i - 1] + prices[i] - fee, buyable[i- 1]);
            sellable[i] = Math.max(buyable[i- 1] - prices[i], sellable[i - 1]);
        }
        // trick -> buyable[i] always larger than buyable[i - 1]
        //          sellable[i] always larger than sellable[i - 1]
        return Math.max(buyable[prices.length - 1], sellable[prices.length - 1]);
    }
}
