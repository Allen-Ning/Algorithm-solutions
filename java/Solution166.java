class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        // trick -> convert to make sure overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        StringBuilder sb = new StringBuilder();

        if ((numerator > 0 && denominator < 0) ||
            (numerator < 0 && denominator > 0)
           ) sb.append("-");

        sb.append(num / den);

        num %= den;
        if (num == 0) return sb.toString();

        HashMap<Long, Integer> map = new HashMap();
        sb.append(".");
        while (num != 0) {
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }

            long value = num * 10;
            sb.append(value / den);
            num = value % den;
        }
        return sb.toString();
    }
}
