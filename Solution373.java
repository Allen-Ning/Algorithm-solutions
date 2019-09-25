class Solution {
    // no implementation trick
    // we need to better use the condition -> two sorted array to reduce time complexity
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) return results;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> (a.total - b.total));
        for (int i = 0; i < nums1.length && i <= k; i++) minHeap.offer(new Pair(i, 0, nums1[i] + nums2[0]));

        while (!minHeap.isEmpty() && results.size() < k) {
            Pair p = minHeap.poll();
            int nextIndex2 = p.index2 + 1;

            List<Integer> result = new ArrayList();
            result.add(nums1[p.index1]);
            result.add(nums2[p.index2]);
            results.add(result);
            
            if (nextIndex2 < nums2.length) minHeap.offer(new Pair(p.index1, nextIndex2, nums1[p.index1] + nums2[nextIndex2]));   
        }
        return results;
    }
}

class Pair {
    int index1;
    int index2;
    int total;
    
    public Pair(int index1, int index2, int total) {
        this.index1 = index1;
        this.index2 = index2;
        this.total = total;
    }
}
