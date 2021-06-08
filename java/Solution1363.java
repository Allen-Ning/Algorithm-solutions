class Solution {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);

        int sum = 0;
        for (int i = 0; i < digits.length; i++) sum += digits[i];
        // trick -> this is to avoid special case -> [0, 0, 0, 0]
        if (sum == 0) return "0";

        StringBuilder sb = new StringBuilder();
        Set<Integer> remainderOne = new HashSet();
        Set<Integer> remainderTwo = new HashSet();

        if (sum % 3 == 0) {
            for (int i = digits.length - 1; i >= 0; i--) sb.append(digits[i]);
        } else if (sum % 3 == 1) {
            helper(digits, sb, remainderOne, remainderTwo, 1);
        } else if (sum % 3 == 2) {
            helper(digits, sb, remainderTwo, remainderOne, 2);
        }
        return sb.toString();
    }

    private void build(StringBuilder sb, Set<Integer> skipIndexs, int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (skipIndexs.contains(i)) continue;
            sb.append(digits[i]);
        }
    }

    private void helper(int[] digits, StringBuilder sb, Set<Integer> one, Set<Integer> two, int check) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 3 == check) {
                one.add(i);
                build(sb, one, digits);
                return;
            } else if (digits[i] % 3 ==  3 - check) {
                if (two.size() >= 2) continue;
                two.add(i);
            }
        }
        if (two.size() == 2) build(sb, two, digits);
    }
}
