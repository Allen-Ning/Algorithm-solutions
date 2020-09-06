public class Solution {
    /**
     * @param pid: the process id
     * @param ppid: the parent process id
     * @param kill: a PID you want to kill
     * @return: a list of PIDs of processes that will be killed in the end
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> childrenByPid = new HashMap();
        for (int i = 0; i < pid.size(); i++) {
            int id = pid.get(i);
            int parentId = ppid.get(i);
            List<Integer> children = childrenByPid.getOrDefault(parentId, new ArrayList());
            children.add(id);
            childrenByPid.put(parentId, children);
        }

        List<Integer> results = new ArrayList();
        helper(childrenByPid, kill, results);
        return results;
    }

    private void helper(Map<Integer, List<Integer>> childrenByPid, int pid, List<Integer> results) {

        results.add(pid);
        List<Integer> children = childrenByPid.get(pid);
        if (children == null) return;
        for (int id : children) helper(childrenByPid, id, results);
    }
}