class Solution {

    // [0,   1,       3,    5,    6,    8,       12, 17]
    // [1, [0, 2], [1,3]  [1,3] [2,3] [1,2,3,4]         ]

    // [0,1,3,5,6,8,12,17]
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;

        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < stones.length; i++) set.add(stones[i]);

        HashMap<Integer, HashSet<Integer>> nextStepRanges = new HashMap();
        HashSet<Integer> nextAvailableSteps = nextStepRanges.getOrDefault(0, new HashSet());
        nextAvailableSteps.add(1);
        nextStepRanges.put(0, nextAvailableSteps);

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            nextAvailableSteps = nextStepRanges.getOrDefault(stone, new HashSet());    
            for (int nextAvailableStep : nextAvailableSteps) {
                int nextStone = stone + nextAvailableStep;
                if (nextStone == stones[stones.length - 1]) return true;
                if (!set.contains(nextStone)) continue;

                HashSet<Integer> nextStoneAvailableSteps = nextStepRanges.getOrDefault(nextStone, new HashSet());
                if (nextAvailableStep - 1 >= 1) nextStoneAvailableSteps.add(nextAvailableStep - 1);
                if (nextAvailableStep >= 1) nextStoneAvailableSteps.add(nextAvailableStep);
                if (nextAvailableStep + 1 >= 1) nextStoneAvailableSteps.add(nextAvailableStep + 1);
                nextStepRanges.put(nextStone, nextStoneAvailableSteps);
            }
        }
        return false;
    }
}
