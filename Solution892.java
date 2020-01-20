class Solution {
    // 1 2 3 4 5 6 7 8 9 10
    // start 1, item 9
    // start 1, end: 10, item: start + item - 1 ->  1 + 10 - 1
    // start 5 end 8, 5 + 4 - 1 -> start + item - 1
    public int consecutiveNumbersSum(int N) {
        if (N == 1) return 1;

        int counter = 0;
        for (int item = 1; item < N && (2 * N - item * item + item) > 0; item++) {
            // trick -> f(start, item) = N
            //          start = ((2 * N - item * item + item) / (2 * item))
            //          if star is integer, we find a valid solution
            //          notice we do this way due to easily find the equation
            //          we don't need to item = squart(start xxxx N)
            boolean isOk = ((2 * N - item * item + item) % (2 * item)) == 0;
            if (isOk) counter++;
        }
        return counter;
    }
}
