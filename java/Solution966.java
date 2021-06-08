class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // trick -> multiple hashMap to lookup
        Set<String> set = new HashSet();
        Map<String, String> lowerCaseMap = new HashMap();
        Map<String, String> vowelMap = new HashMap();
        for (String str : wordlist) {
            String lowerStr = str.toLowerCase();
            String vowelStr = getDeVowelKey(lowerStr);
            set.add(str);
            if (!lowerCaseMap.containsKey(lowerStr)) lowerCaseMap.put(lowerStr, str);
            if (!vowelMap.containsKey(vowelStr)) vowelMap.put(vowelStr, str);
        }

        String[] results = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String lowerQuery = queries[i].toLowerCase();
            String vowelKey = getDeVowelKey(lowerQuery);
            if (set.contains(queries[i])) {
                results[i] = queries[i];
            } else if (lowerCaseMap.containsKey(lowerQuery)) {
                results[i] = lowerCaseMap.get(lowerQuery);
            } else if (vowelMap.containsKey(vowelKey)) {
                results[i] = vowelMap.get(vowelKey);
            } else {
                results[i] = "";
            }
        }
        return results;
    }

    private String getDeVowelKey(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u'
               ) {
                sb.append('*');
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}