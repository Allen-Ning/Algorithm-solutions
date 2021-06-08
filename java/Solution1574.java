class Solution {
    public int findLengthOfShortestSubarray(int[] array) {
        boolean isIncreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i+ 1]) continue;
            isIncreasing = false;
            break;
        }
        if (isIncreasing) return 0;

        // trick -> calculate the maximum decreasing from end to start
        int j = -1;
        for (j = array.length - 1; j >= 0; j--) {
            if (j == 0) break;
            if (array[j] < array[j - 1]) break;
        }

        // trick -> the minimum result is to remove all the prefix and only keep the last part [j, array.length - 1] as increasing part
        int result = j;
        // trick -> calculate the maximum increasing array -> [0,i] + [j, array.length -1]
        //            [0 i]        [i + 1, j - 1] [j, array.length -1]
        //          increasing      removed part         increasing
        //                [i + i, j - 1] is the removed part
        //          this is o(n) not o(n^2) cos j is keeping moving
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] < array[i - 1]) break;
            while (j < array.length && array[i] > array[j]) j++;
            result = Math.min(result, j - i - 1);
        }
        return result;
    }
}