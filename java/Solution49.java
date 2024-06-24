class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] letters = new char[26];
            // trick -> this is to record how many times for each char from 'a' to 'z'
            for (char c : str.toCharArray()) letters[c - 'a'] += 1;
            String key = new String(letters);

            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(str);
            map.put(key, list);
        }

        List<List<String>> results = new ArrayList();
        // trick -> syntax keySet();
        for (String key : map.keySet()) {
            results.add(map.get(key));
        }
        return results;
    }
}