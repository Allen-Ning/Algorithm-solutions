class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) return false;

        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                int target = 5;
                if (five == 0) return false;
                five -= 1;
                ten++;
            } else if (bill == 20) {
                int target = 15;
                if (ten >= 1) {
                    ten -= 1;
                    target -= 10;
                }
                
                if (5 * five >= target) {
                    five -= target / 5;
                    target = 0;
                    twenty++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
