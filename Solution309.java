class Solution {
  public int maxProfit(int[] prices) {
    int availableToBuy = 0;
    int withStock = Integer.MIN_VALUE;
    int noStock = Integer.MIN_VALUE;

    for (int price : prices) {
      int preAvailableToBuy = availableToBuy;
      int preStock = withStock;
      int preNoStock = noStock;

      availableToBuy = Math.max(preAvailableToBuy, preNoStock);
      withStock = Math.max(preAvailableToBuy - price, preStock);
      noStock = preStock + price;
    }

    return Math.max(noStock, availableToBuy);
  }
}
