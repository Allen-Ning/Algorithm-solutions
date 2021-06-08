class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int counter = 1;
        while (sb.length() < B.length()) {
            sb.append(A);
            counter++;
        }

        if (sb.indexOf(B) != -1) return counter;
        // trick -> add another A
        // Reference: https://leetcode.com/problems/repeated-string-match/discuss/224182/Explanation-on-the-Intuitive-Python-2-liner-solution
        sb.append(A);
        counter++;
        return sb.indexOf(B) == -1 ? -1 : counter;
    }
}
