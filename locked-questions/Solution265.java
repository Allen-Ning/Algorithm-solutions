public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        if (costs[0].length == 1) return costs[0][0];

        // trick -> preMin is the min sum value from last round
        //          preSec is the sec minimum sum value from last round
        int preMin = 0;
        int preSec = 0;
        int preMinIndex = -1;
        for (int i = 0; i < costs.length; i++) {
            int currentMin = Integer.MAX_VALUE;
            int currentSec = Integer.MAX_VALUE;
            int currentMinIndex = -1;
            for (int j = 0; j < costs[i].length; j++) {
                // trick -> this is smart move to avoid extra loop check
                //          if preMinIndex is the same as the current i, use the preSec
                //          otherwise use preMin
                int min = (i > 0 && j == preMinIndex) ? preSec : preMin;
                int value = costs[i][j] + min;

                if (value < currentMin) {
                    currentSec = currentMin;
                    currentMin = value;
                    currentMinIndex = j;
                } else if (value < currentSec) {
                    currentSec = value;
                }
            }
            preMin = currentMin;
            preSec = currentSec;
            preMinIndex = currentMinIndex;
        }
        return preMin;
    }
}