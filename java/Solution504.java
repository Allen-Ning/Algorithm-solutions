class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "0";

        int absNum = Math.abs(num);
        while (absNum > 0) {
            sb.append(absNum % 7);
            absNum = absNum / 7;
        }

        if (num < 0) sb.append("-");
        return sb.reverse().toString();
    }
}