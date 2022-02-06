class Solution {
    // trick -> repeated pattern only count one time
    //          3 website sequences could be non-consecutive sequence
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) { 
        Visit[] visits = new Visit[username.length];
        for (int i = 0; i < username.length; i++) {
            visits[i] = new Visit(username[i], timestamp[i], website[i]);
        }

        Arrays.sort(visits, (visit1, visit2) -> visit1.timestamp - visit2.timestamp);

        HashMap<String, Integer> map = new HashMap();
        Map<String, HashSet<String>> patterns = new HashMap();
        int maxCounter = 0;
        String resultKey = "";

        List<String> result = new ArrayList();
        for (int i = 0; i < visits.length; i++) {
            for (int j = i + 1; j < visits.length; j++) {
                for (int z = j + 1; z < visits.length; z++) {
                    if (visits[i].username.equals(visits[j].username) &&
                        visits[j].username.equals(visits[z].username)) {
                        String key = visits[i].website + "_" + visits[j].website + "_" + visits[z].website;
 
                        HashSet<String> set = patterns.getOrDefault(key, new HashSet());
                        if (set.contains(visits[i].username)) continue;
                        set.add(visits[i].username);
                        patterns.put(key, set);

                        int counter = map.getOrDefault(key, 0) + 1;
                        if (counter > maxCounter ||
                            (counter == maxCounter && key.compareTo(resultKey) < 0)
                           ) {

                            result = new ArrayList(); 
                            result.add(visits[i].website);
                            result.add(visits[j].website);
                            result.add(visits[z].website);

                            maxCounter = counter;
                            resultKey = key;
                        }
                        map.put(key, counter);
                    }
                }
            }
        }
        return result;
    }

    class Visit {
        String username;
        int timestamp;
        String website;

        public Visit(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }
}