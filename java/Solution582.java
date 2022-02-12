class Solution {
    public List<Integer> killProcess(List<Integer> pids, List<Integer> ppids, int kill) {
        HashMap<Integer, Set<Integer>> map = new HashMap();
        for (int i = 0; i < ppids.size(); i++) {
            int ppid = ppids.get(i);
            int pid = pids.get(i);

            Set<Integer> set = map.getOrDefault(ppid, new HashSet());
            set.add(pid);
            map.put(ppid, set);
        }

        List<Integer> results = new ArrayList();
        helper(map, 0, kill, results, false);

        return results;
    }

    private void helper(HashMap<Integer, Set<Integer>> map, int current, int kill, List<Integer> results, boolean added) {

        if (added) results.add(current);
        Set<Integer> children = map.get(current);
        
        if (children == null) return;

        for (int child : children) {
            helper(map, child, kill, results, added || child == kill);
        }
    }
}