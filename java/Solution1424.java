class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int rows = nums.size();
        if (nums == null || rows == 0) return new int[]{};

        List<Integer> tempResults = new ArrayList();
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {0, 0});
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                tempResults.add(nums.get(x).get(y));

                // trick -> only element in the first column needs to check the element in the bottom
                //          others element in non first column only needs to check the element in the right
                if (y == 0 &&
                    x + 1 < rows &&
                    y < nums.get(x + 1).size()
                   ) {
                    queue.add(new int[] {x + 1, y});
                }

                if (y + 1 < nums.get(x).size()) {
                    queue.add(new int[] {x, y + 1});
                }
            }
        }

        int[] results = new int[tempResults.size()];
        int index = 0;
        for (int num : tempResults) results[index++] = num;
        return results;
    }
}