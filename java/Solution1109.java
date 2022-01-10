class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] preSum = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0];
            int end = bookings[i][1];
            int seat = bookings[i][2];

            preSum[start - 1] += seat;
            if (end < preSum.length) preSum[end] -= seat;
        }

        int[] results = new int[n];
        int carry = 0;
        for (int i = 0; i < preSum.length; i++) {
            results[i] = preSum[i] + carry;
            carry = results[i];
        }
        return results;
    }
}