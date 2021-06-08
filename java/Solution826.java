class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> maxProfitMap = new TreeMap();
        for (int i = 0; i < difficulty.length; i++) {
            int existingProfit = maxProfitMap.getOrDefault(difficulty[i], 0);
            // trick -> special case to avoid same difficulty but different profit
            if (profit[i] > existingProfit) maxProfitMap.put(difficulty[i], profit[i]);
        }
        Arrays.sort(difficulty);

        int currentMaxProfit = 0;
        for (int i = 0; i < difficulty.length; i++) {
            currentMaxProfit = Math.max(currentMaxProfit, maxProfitMap.get(difficulty[i]));
            maxProfitMap.put(difficulty[i], currentMaxProfit);
        }

        int result = 0;
        for (int each : worker) {
            Integer key = maxProfitMap.floorKey(each);
            if (key == null) continue;

            result += maxProfitMap.get(key);
        }
        return result;
    }
}
