class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap();
        for (String cpdomain : cpdomains) {
            String[] data = cpdomain.split(" ");
            int count = Integer.valueOf(data[0]);
            // trick -> we need \\. to parse the special character
            String[] domains = data[1].split("\\.");
            String key = domains[domains.length - 1];
            map.put(key, map.getOrDefault(key, 0) + count);
            for (int i = domains.length - 2; i >= 0; i--) {
                key = domains[i] + "." + key;
                map.put(key, map.getOrDefault(key, 0) + count);
            }
        }
        List<String> results = new ArrayList();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String result = entry.getValue() + " " + entry.getKey();
            results.add(result);
        }
        return results;
    }
}
