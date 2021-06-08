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

    public int numTeams2(int[] rating) {
        int result = 0;

        FenwichTree left = new FenwichTree((int)1e5 + 1);
        FenwichTree right = new FenwichTree((int)1e5 + 1);

        for (int score : rating) right.update(score, 1);

        for (int score : rating) {
            int leftSmallerNum = left.query(score - 1);
            int leftLargerNum = left.query((int)1e5) - left.query(score);
            right.update(score, -1);
            left.update(score, 1);

            int rightLargerNum = right.query((int)1e5) - right.query(score);
            int rightSmallerNum = right.query(score - 1);
            result += leftSmallerNum * rightLargerNum + leftLargerNum * rightSmallerNum;
        }
        return result;
    }

    class FenwichTree {
        int[] data;

        public FenwichTree(int n) {
            this.data = new int[n];
        }

        public void update(int index, int delta) {
            while (index < data.length) {
                data[index] += delta;
                index += index & (-index);
            }
        }

        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += data[index];
                index -= index & (-index);
            }
            return sum;
        }
    }
}
