class Solution {
    // time complexity o(n)
    public int addDigits(int num) {
        int reminder = 0;
        while (num > 0) {
            reminder += num % 10;
            if (num / 10 == 0 && reminder < 10) {
                break;
            } else if (num / 10 == 0 && reminder >= 10) {
                num = reminder;
                reminder = 0;
            } else {
                num = num / 10;
            }
        }
        return reminder;
    }

    //      /  0             (n == 0)
    // dr(n) = { 9           (n != 0 && n % 9 == 0)
    //      \ n % 9          (n % 9 != 0)

    // equals to

    // dr(n) = 1 + (n - 1) % 9
    // time complexity o(1)
    public int addDigits2(int num) {
        if (num == 0) return 0;

        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
