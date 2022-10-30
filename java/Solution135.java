class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        // left -> right
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] >= ratings[i + 1]) continue;

            candy[i + 1] = Math.max(candy[i + 1], candy[i] + 1);
        }

        // right -> left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] <= ratings[i + 1]) continue;
            
            candy[i] = Math.max(candy[i], candy[i + 1] + 1);
        }

        int result = 0;
        for (int i = 0; i < candy.length; i++) {
            result += candy[i];
        }

        return result;
    }
}