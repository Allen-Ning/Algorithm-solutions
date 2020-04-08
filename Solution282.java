class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> results = new ArrayList();
        if (num == null || num.length() == 0) return results;
        helper(num, target, 0, results, "", 0, 0);
        return results;
    }

    private void helper(String num, int target, int index, List<String> results, String str, long sum, long prev) {
        if (index >= num.length()) {
            // trick -> need to compare long just in case sum too large, which leads to overflow
            //          if we compare (int) sum == target, when sum is 2147483648, it will convert to -2147483648 as integer
            if (index == num.length() && sum == (long) target) {
                results.add(str);
            }
            return;
        }

        StringBuilder sb = new StringBuilder(str);
        for (int i = index + 1; i <= num.length(); i++) {
            if (num.charAt(index) == '0' && i > index + 1) break;
            String current = num.substring(index, i);
            long value = Long.valueOf(current);

            char[] ops = new char[] {'+', '-', '*'};
            // trick -> needs to special take care of when index is 0
            if (index == 0) {
                helper(num, target, i, results, str + current, value, value);
            } else {
                for (char op : ops) {
                    String newStr = str + op + current;
                    if (op == '+') {
                        helper(num, target, i, results, newStr, sum + value, value);
                    } else if (op == '-') {
                        helper(num, target, i, results, newStr, sum - value, -1 * value);
                    } else if (op == '*') {
                        // trick -> this special (sum - prev) + prev * value help for quick calucation if encountering *
                        helper(num, target, i, results, newStr, sum - prev + prev * value, prev * value);
                    }
                }
            }
        }
    }
}
