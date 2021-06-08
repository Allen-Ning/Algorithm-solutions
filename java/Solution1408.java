class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet();
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].contains(words[j])) set.add(words[j]);
            }
        }

        List<String> list = new ArrayList();
        for (String str : set) list.add(str);
        return list;
    }
}
