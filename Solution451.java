class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        String result = "";

        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                max = Math.max(max, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        String[] buckets = new String[max + 1];
        Arrays.fill(buckets, "");

        for (Map.Entry<Character, Integer> record : map.entrySet()) {
            int value = record.getValue();
            char key = record.getKey();
            
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= value; j++) {
                sb.append(key + "");
            }
            buckets[record.getValue()] += sb.toString();
        }

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i].equals("")) continue;
            result += buckets[i];
        }
        return result;
    }
}
