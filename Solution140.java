class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet();
        HashMap<String, List<String>> map = new HashMap();
        for (String word: wordDict) set.add(word);
        List<String> list = helper(map, new ArrayList<String>(), set, s);
        return list;
    }

    private List<String> helper(HashMap<String, List<String>> map, ArrayList<String> list, HashSet<String> set, String s) {
        if (map.containsKey(s)) return map.get(s);
        if (s.length() == 0) {
            return null;
        }

        List<String> words = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i + 1);
            boolean hasWord = set.contains(word);
            if (!hasWord) continue;
            list.add(word);
            List<String> partResults = helper(map, list, set,s.substring(i + 1));
            if (partResults == null) {
                words.add(word);
            } else {
                for (String part : partResults) {
                    words.add(word + " " + part);
                }
            }
            list.remove(list.size() - 1);
        }

        map.put(s, words);
        return words;
    }
}
