public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList();
        if (nums1.length == 0 || nums2.length == 0) return results;

        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> nums1[e1[0]] + nums2[e1[1]] - nums1[e2[0]] - nums2[e2[1]]);
        for (int i = 0; i < nums1.length; i++) queue.offer(new int[] {i, 0});
        int counter = 0;

        while (queue.size() > 0) {
            int[] current = queue.poll();
            List<Integer> result = new ArrayList();

            result.add(nums1[current[0]]);
            result.add(nums2[current[1]]);
            results.add(result);

            counter++;

            if (counter == k) return results;
            if (current[1] + 1 < nums2.length) queue.offer(new int[] {current[0], current[1] + 1});
        }
        
        return results;
    }
}