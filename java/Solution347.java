class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> result = new ArrayList();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue())); 
        for (Map.Entry<Integer, Integer> record : map.entrySet()) {
            q.offer(record);
            if (q.size() > k) {
                q.poll();
            }
        }

        for (Map.Entry<Integer, Integer> value : q) result.add(value.getKey());
        return result;
    }
}
