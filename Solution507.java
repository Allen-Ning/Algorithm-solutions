class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int result = 1;
        // trick -> find the mid number to avoid further calculation
        //          e.g 28 = 1, 2 * 14, 4 *7 so that the largest number we 
        //              need to find the Math.sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                result += i;
                result += (num / i);
            }
        }
        return result == num;
    }
}
