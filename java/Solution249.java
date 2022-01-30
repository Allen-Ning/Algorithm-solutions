class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        int mod = 26;

        HashMap<String, List<String>> map = new HashMap();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            int offset = str.charAt(0) - 'a';
            for (int i = 0; i < str.length(); i++) {
                char current = str.charAt(i);
                char c = (char) ((current - 'a' - offset + mod) % mod + 'a');
                sb.append(c);
            }
            String lookupKey = sb.toString();
            List<String> result = map.getOrDefault(lookupKey, new ArrayList<String>());
            result.add(str);
            map.put(lookupKey, result);
        }

        List<List<String>> results = new ArrayList();
        for (String key : map.keySet()) results.add(map.get(key));
        return results;
    }
}