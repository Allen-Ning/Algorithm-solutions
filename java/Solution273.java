class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int index = 0;

        String result = "";
        while (num > 0) {
            if (num % 1000 > 0) {
                result = helper(num % 1000) + " " + THOUSANDS[index] + "" + result;
            }
            index++;
            num /= 1000;
        }
        return result.trim();
    }

    private String helper(int num) {
        if (num < 20 ) return " " + LESS_THAN_20[num]; 

        String str = "";
        if (num / 100 > 0) {
            str += " "+ LESS_THAN_20[num / 100] + " Hundred";
            if (num % 100 > 0) str += helper(num % 100); 
        } else if (num / 20 > 0) {
            str += " " + TENS[num / 10];
            if (num % 10 > 0) str += helper(num % 10);
        }
        return str;
    }
}
