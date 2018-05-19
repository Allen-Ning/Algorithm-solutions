import java.util.List;
import java.util.ArrayList;

public class Solution797 {

    private List<List<Integer>> result;
    private int[][] graph;

    public static void main(String[] args) {
        Solution797 s = new Solution797();
        s.allPathsSourceTarget(new int[][] { {1,2}, {3}, {3}, {}});
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList();
        this.result = new ArrayList();
        this.graph = graph;
        list.add(0);
        helper(list, 0);
        return result;
    }

    public void helper(List<Integer> list, int node) {
        if (node == graph.length - 1) {
            result.add(new ArrayList(list));
            return;
        }

        for (int newNode: graph[node]) {
            list.add(newNode);
            helper(list, newNode);
            list.remove(list.size() -1);
        }
    }
}
