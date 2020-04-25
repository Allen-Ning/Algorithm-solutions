class Solution {
    public boolean rotateString(String A, String B) {
        // eg. trick -> e.g. // abcde|abcde
                             //   cde ab
        return A.length() == B.length() && (A + A).contains(B);
    }
}
