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
}
