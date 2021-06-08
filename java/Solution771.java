class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) return 0;

        HashSet<Character> set = new HashSet();
        for (int i = 0; i < J.length(); i++) set.add(J.charAt(i));

        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) counter++;
        }
        return counter;
    }
}
