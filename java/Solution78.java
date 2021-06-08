import java.util.List;
import java.util.ArrayList;

public class Solution78 {

    private int[] nums;
    private List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.list = new ArrayList();
        List<Integer> result = new ArrayList();
        list.add(new ArrayList());
        helper(result, 0);
        return list;
    }

    private void helper(List<Integer> result, int start) {
        if (result.size() == this.nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            result.add(this.nums[i]);
            list.add( new ArrayList(result));
            helper(result, i + 1);
            result.remove(result.size() - 1);
        }
    }
}
