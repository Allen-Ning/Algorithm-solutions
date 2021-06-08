class Solution {
    HashMap<String, PriorityQueue<String>> map;
    List<String> results; 
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap();
        results = new ArrayList();
        for (List<String> ticket: tickets) {
            String dep = ticket.get(0);
            String arrival = ticket.get(1);
            PriorityQueue<String> values = null;
            if (map.containsKey(dep)) {
              values = map.get(dep);
            } else {
              values = new PriorityQueue();
            }
            values.offer(arrival);
            map.put(dep,values);  
        }
        
        helper("JFK");
        return results;
    }
                      
    private void helper(String dep) {
        PriorityQueue<String> arrivals = map.get(dep);
        while (arrivals != null && arrivals.size() > 0) {
            String arrival = arrivals.poll();
            helper(arrival);
        }
        results.add(0, dep);
    }
}
