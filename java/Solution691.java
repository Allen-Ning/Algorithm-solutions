class Solution {
    // TODO - it seems like this question can be solved by top-down dfs with memorization
    public int minStickers(String[] stickers, String target) {
        //  xxxxxx
        //  thehat
        // 1000000 => 0 - 111111
        int allStatues = 1 << target.length();
        int dp[] = new int[allStatues];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String sticker : stickers) {
                int nextStatus = getNextStatus(i, sticker, target);
                dp[nextStatus] = Math.min(dp[nextStatus], dp[i] + 1);
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

    private int getNextStatus(int status, String sticker, String target) {
        int nextStatus = status;
        int length = target.length();
        for (int i = 0; i < sticker.length(); i++) {
            for (int j = 0; j < length; j++) {
                // trick -> this step is to find the next status
                //          if the current char at j is not being counted
                //          target:     abc
                //          nextStatus: 101 (0 means not filled)
                //                       j
                //          sticker:    abz
                if ((nextStatus >> j & 1) == 0 &&
                    target.charAt(j) == sticker.charAt(i))
                {
                    nextStatus = (nextStatus | (1 << j));
                    break;
                }
            }
        }
        return nextStatus;
    }
}
