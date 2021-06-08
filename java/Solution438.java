class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() < p.length()) return new ArrayList();

        List<Integer> result = new ArrayList();
        int[] list = new int[26];
        for (int i = 0; i < p.length(); i++) list[p.charAt(i) - 'a']++;

        int left = 0, right = 0, counter = p.length();
        // trcik -> there are lots of trick in the implementation below
        // in general, in order to do o(n)
        // if we move the right of window, we need to do subtract operation from counter or list
        // if we move the left of window, we need to do add operation from the counter or list
        while (right < s.length()) {
            if (list[s.charAt(right) - 'a'] > 0) counter--;
            list[s.charAt(right) - 'a']--;

            if (right - left == p.length()) {
                if (list[s.charAt(left) - 'a'] >= 0) counter++;
                list[s.charAt(left) - 'a']++;
                left++;
            }

            if (counter == 0) result.add(left);
            right++;
        }

        return result;
    }
}
