class Solution {
    // zero   z -> 0   -> zero
    // one             -> one  -> total o - z - w - u
    // two    w -> 2   -> two
    // three           -> thr2e  -> total h - g
    // four   u -> 4   -> four
    // five            -> five -> total f - u
    // six    x -> 6   -> six
    // seven           -> s2evn -> total v - (total f - u)
    // eight  g -> 8   -> eight 
    // nine            -> 2nie -> total i - (total f - u) - six - eight
    public String originalDigits(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) nums[s.charAt(i) - 'a']++;

        int[] counter = new int[10];
        counter[0] = nums['z' - 'a'];
        counter[2] = nums['w' - 'a'];
        counter[4] = nums['u' - 'a'];
        counter[6] = nums['x' - 'a'];
        counter[8] = nums['g' - 'a'];

        counter[1] = nums['o' - 'a'] - counter[0] - counter[2] - counter[4];
        counter[3] = nums['h' - 'a'] - counter[8];
        counter[5] = nums['f' - 'a'] - counter[4];
        counter[7] = nums['v' - 'a'] - counter[5];
        counter[9] = nums['i' - 'a'] - counter[5] - counter[6] - counter[8];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            int num = counter[i];
            while (num > 0) {
                sb.append(i);
                num--;
            }
        }
        return sb.toString();
    }
}
