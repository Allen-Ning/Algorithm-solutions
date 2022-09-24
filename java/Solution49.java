class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList();
        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> result = map.getOrDefault(key, new ArrayList());
            result.add(str);
            map.put(key, result);
        }

        // easy to forget about syntax for loop map
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> result = entry.getValue();
            results.add(result);
        }
        return results;
    }
}