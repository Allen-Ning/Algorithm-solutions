class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);

        int max = 0;
        int min = Integer.MAX_VALUE;
        int n = stones.length;
        if (stones[n - 1] - stones[0] + 1 == n) return new int[]{0, 0};

        if (stones[1] - stones[0] < stones[n - 1] - stones[n - 2]) {
            // e.g. move left first
            // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
            // x . . x x . . x x . .  .  .  x
            // ...xxx.xx.....x
            // .........xxxxxx
            max = (stones[n - 1] - stones[1] + 1 ) - (n - 1);
        } else {
            // e.g. move right first
            // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
            // x . . . . . x x . . x  x  .  x
            // x . . . . . x x . x x  x  .  .
            // 11 - 0 + 1 - (6 - 1)
            max = (stones[n - 2] - stones[0] + 1) - (n - 1);
        }

        int num = 0;
        int window = n;
        int j = 0;

        // e.g. corner case needs two moves (n - 1 stones stay together)
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
        // . . . x x x x x . . .  .   .  . x
        //       x x x x x x
        if (stones[n - 2] - stones[0] + 1 == window - 1 && stones[n - 1] - stones[n - 2] + 1 > 3) return new int[] {2, max};

        // e.g. corner case needs two moves (n - 1 stones stay together)
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
        // x . . x x x x x . . .   .  .  .  .
        //       x x x x x x
        if (stones[n - 1] - stones[1] + 1 == window - 1 && stones[1] - stones[0] + 1 > 3) return new int[] {2, max};

        for (int i = 0; i < stones.length; i++) {
            int startStonePosition = stones[i];
            // trick -> a sliding window is needed and move the stones into this current sliding window
            while (j < stones.length && stones[j] <= startStonePosition + window - 1) {
                j++;
                num++;
            }

            // e.g. normal case to fill the empty slot
            // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
            // x . . x x . . x . . .  .   x  .  x
            //       x x x x x x
            min = Math.min(min, window - num);
            num--;
        }
        return new int[] {min, max};
    }
}
