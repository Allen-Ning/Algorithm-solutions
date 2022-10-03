class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // preprocessing
        int[] leftCandles = new int[s.length()];
        int[] rightCandles = new int[s.length()];
        int[] preSum = new int[s.length()];

        int lastPos = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') lastPos = i;

            leftCandles[i] = lastPos;
        }

        lastPos = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '|') lastPos = i;

            rightCandles[i] = lastPos;
        }

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') counter++;
            preSum[i] = counter;
        }

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int leftCandle = rightCandles[query[0]];
            int rightCandle = leftCandles[query[1]];

            int result = 0;
            // trick -> we need this leftCandle <= rightCandle to avoid corner cases
            //          e.g "***|**|*****|**||**|*"
            //          query [4, 5]
            if (leftCandle != s.length() && rightCandle != -1 && leftCandle <= rightCandle) {
                result = preSum[rightCandle] - preSum[leftCandle];
            }
            results[i] = result;
        }
        return results;
    }
}