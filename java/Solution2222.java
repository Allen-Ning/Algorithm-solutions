class Solution {
    // use long[] to replace hashmap to make it run faster
    public long numberOfWays(String s) {
        long[] map = new long[6];
        // 0  1   2  3    4   5
        // 0, 1, 10, 01, 010, 101
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                map[0] += 1;
                map[2] += map[1];
                map[4] += map[3];
            } else {
                map[1] += 1;
                map[3] += map[0];
                map[5] += map[2];
            }   
        }
        return map[4] + map[5];
    }

    // hashmap implementation
    public long numberOfWays2(String s) {
        Map<String, Long> map = new HashMap();
        map.put("0", (long) 0);
        map.put("1", (long) 0);
        map.put("01", (long) 0);
        map.put("10", (long) 0);
        map.put("101", (long) 0);
        map.put("010", (long) 0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                map.put("0", map.get("0") + 1);
                map.put("10", map.get("10") + map.get("1"));
                map.put("010", map.get("010") + map.get("01"));
            } else {
                map.put("1", map.get("1") + 1);
                map.put("01", map.get("01") + map.get("0"));
                map.put("101", map.get("101") + map.get("10"));
            }
        }
        return map[4] + map[5];
    }
}