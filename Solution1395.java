class Solution {
    public int numTeams(int[] rating) {
        int result = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int current = rating[i];

            int leftSmallerCounter = 0;
            int leftLargerCounter = 0;
            int rightSmallerCounter = 0;
            int rigthtLargerCounter = 0;

            int index = i;
            while (--index >= 0) {
                if (current > rating[index]) leftSmallerCounter++;
                if (current < rating[index]) leftLargerCounter++;
            }

            index = i;
            while (++index < rating.length) {
                if (current > rating[index]) rightSmallerCounter++;
                if (current < rating[index]) rigthtLargerCounter++;
            }
            result += leftSmallerCounter * rigthtLargerCounter + leftLargerCounter * rightSmallerCounter;
        }
        return result;
    }
}