public class Solution {
    // trick -> cannot ac due to time limit
    public int balanceGraph(int[][] edges) {
        Map<Integer, Integer> map = new HashMap();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            map.put(from, map.getOrDefault(from, 0) - weight);
            map.put(to, map.getOrDefault(to, 0) + weight);
        }

        int result = 0;
        List<Integer> list = new ArrayList();
        for (int value : map.values()) {
            if (value == 0) continue;
            list.add(value);
        }
        Collections.sort(list);

        int l = 0;
        int h = list.size() - 1;
        List<Integer> checkedList = new ArrayList();
        int index = 0;
        while (l <= h) {
            if (list.get(l) + list.get(h) == 0) {
                l++;
                h--;
                result++;
            } else if (list.get(l) + list.get(h) > 0) {
                checkedList.add(list.get(h));
                h--;
            } else if (list.get(l) + list.get(h) < 0) {
                checkedList.add(list.get(l));
                l++;
            }
        }
        Collections.sort(checkedList);

        int[] nums = new int[checkedList.size()];
        int[] results = new int[] { Integer.MAX_VALUE };
        if (checkedList.size() > 0) {
            int end = 0;
            for (int i = 0; i < checkedList.size(); i++) {
                nums[i] = checkedList.get(i);
                if (i < checkedList.size() - 1 && checkedList.get(i) < 0 && checkedList.get(i + 1) > 0) end = i;
            }
            helper(nums, results, checkedList.size() - 1, end, 0);
        }
        if (results[0] != Integer.MAX_VALUE) result += results[0];
        return result;
    }

    private void helper(int[] list, int[] results, int index, int end, int counter) {
        if (index == end) {
            results[0] = Math.min(counter, results[0]);
            return;
        }

        if (counter >= results[0]) return;

        int result = list[index];
        for (int i = 0; i <= end; i++) {
            int value = list[i];
            if (value == 0) continue;

            if (value + result <= 0) {
                list[i] = value + result;
                index--;
            } else {
                list[index] = value + result;
                list[i] = 0;
            }
            counter += 1;

            helper(list, results, index, end, counter);

            counter -= 1;
            if (value + result <= 0) {
                list[i] = value;
                index++;
            } else {
                list[index] = result;
                list[i] = value;
            }
        }
    }
}