class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int mod = (int)(1e9 + 7);
        // [2, 8, 4, 10, 6]
        Arrays.sort(inventory);

        // [2, 4，6，8]
        // [2, 4，6，6]
        // [2, 4，4，4]
        long profit = 0;
        int i = inventory.length - 1;
        for (i = inventory.length - 1; i > 0; i--) {
            if (inventory[i] == inventory[i - 1]) continue;

            long sum = 0;
            long removedOrder = 0;

            sum = (long)(inventory[i] + inventory[i - 1] + 1) * (long)(inventory[i] - inventory[i - 1] ) / 2 * (long)(inventory.length - i);
            removedOrder =  (long)(inventory.length - i) * (long)(inventory[i] - inventory[i - 1]);
            // to many for one shot
            if (removedOrder > orders) break;

            orders -= removedOrder;
            profit += sum;
            profit %= mod;
            if (orders == 0) return (int) profit;
        }

        //     i
        // [2, 4，4，4]
        int value = inventory[i];
        int batchSize = inventory.length - i;
        int batchRemovedOrder = orders / batchSize;
        int leftOrder = orders % batchSize;
        profit += (long)(value + value - batchRemovedOrder + 1) * (long)(batchRemovedOrder) / (long)2 * (long)batchSize;
        profit %= mod;
        profit += (long)leftOrder * (long)(value - batchRemovedOrder);
        profit %= mod;
        return (int) profit;
    }
}