class Solution {
    public List<String> letterCombinations(String digits) {
        /**
            2 -> [a, b, c]
            3 -> [d, e, f]

            a       b       c
           d e f  d e f  d  e  f
         */
        // trick -> this could make implementation much easier
        String[] values = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> results = new ArrayList<>();
        if (digits.length() == 0) return results;

        helper(results, "", digits, values, 0);
        return results;
    }

    private void helper(List<String> results, String result, String digits, String[] values, int index) {
        if (index >= digits.length()) {
            results.add(result);
            return;
        }

        int numnber = digits.charAt(index) - '0';
        for (Character c : values[numnber].toCharArray()) {
            // trick -> string will not change after appending a more char
            //          e.g.  String a = "a";
            //                String b = a + "b";
            //                System.out.println(a); -> output: a
            //                System.out.println(b); -> output: ab
            helper(results, result + c, digits, values, index + 1);
        }
    }
}