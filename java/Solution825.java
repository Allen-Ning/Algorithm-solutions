class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) return 0;
        int[] ageCount = new int[121];
        int[] rangeAgeSum = new int[121];

        int result = 0;
        for (int age : ages) ageCount[age] += 1;

        for (int i = 1; i < ageCount.length; i++) rangeAgeSum[i] = rangeAgeSum[i - 1] + ageCount[i];

        // trick -> by caculation A must starts from 15
        // if A sends to B, we have to make sure the two conditions below happening at the same time
        // age[B] > 0.5 * age[A] + 7
        // age[B] < age[A]
        //  -1 means not sending to themself
        for (int i = 15; i < rangeAgeSum.length; i++) {
            result += (rangeAgeSum[i] - rangeAgeSum[i / 2 + 7] - 1) * ageCount[i];
        }
        return result;  
    }
}
