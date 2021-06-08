class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        int max = 0;
        for (int value : machines) {
            total += value;
            max = Math.max(value, max);
        }

        if (total % machines.length != 0) return -1;
        int average = total / machines.length;

        int[] leftOut = new int[machines.length];
        int[] rightOut = new int[machines.length];

        // trick -> we need this function below to calculate each leftOut[i], rightOut[i]
        // leftOut[0] = 0;
        // leftOut[i] + rightOut[i] = machines[i] - average;
        // rightOut[length - 1] = 0;

        // trick -> use the above function to get these functions below
        // leftOut[i] -> means how many dresses to move left
        // e.g leftOut[i] = 3 means move 3 items to the left side
        //     leftOut[i] = -2 means get 2 items from left side
        // rightOut[i] -> means how many dresses to move right
        // e.g rightOut[i] = 3 means move 3 items to the right side
        //     rightOut[i] = -2 means get 2 items from right side
        // leftOut[i] = -rightOut[i - 1];
        // rightOut[i] = machines[i] - average - leftOut[i];
        leftOut[0] = 0;
        rightOut[0] = machines[0] - average - leftOut[0];
        for (int i = 1; i < machines.length; i++) {
            leftOut[i] = -rightOut[i - 1];
            rightOut[i] = machines[i] - average - leftOut[i];
        }

        int result = 0;
        for (int i = 0; i < machines.length; i++) {
            int value = 0;
            if (leftOut[i] > 0) value += leftOut[i];
            if (rightOut[i] > 0) value += rightOut[i];
            result = Math.max(result, value);
        }
        return result;
    }
}