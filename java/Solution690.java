/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0 || id < 0) return 0;
        HashMap<Integer, Employee> map = new HashMap();
        for (Employee e : employees) map.put(e.id, e);

        int result = 0;
        Queue<Employee> queue = new LinkedList();
        Employee e = map.get(id);
        queue.offer(e);
        while (!queue.isEmpty()) {
            e = queue.poll();
            result += e.importance;
            if (e.subordinates.size() == 0) continue;
            for (int subordinateId : e.subordinates) {
                queue.offer(map.get(subordinateId));
            }
        }
        return result;
    }
}
