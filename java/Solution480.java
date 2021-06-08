class Solution {
    class Element {
        double value;
        int index;
        public Element(double value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Element> max = new TreeSet<>((a, b) -> (b.value - a.value == 0 ? b.index - a.index : (int) (b.value - a.value)));
        TreeSet<Element> min = new TreeSet<>((a, b) -> (a.value - b.value == 0 ? a.index - b.index : (int)(a.value - b.value)));

        // trick -> we need deque to find the element to be removed
        Deque<Element> deque = new LinkedList();
        for (int i = 0; i < k; i++) {
            if (i >= nums.length) break;
            Element e = new Element(nums[i], i);
            max.add(e);
            deque.offerLast(e);
        }

        int halfSize = k / 2;
        // trick -> this is for handling special case when k larger than nums.length
        if (k > nums.length) halfSize = nums.length / 2;

        for (int i = 0; i < halfSize; i++) {
            Element value = max.first();
            max.remove(value);
            min.add(value);
        }

        int size = nums.length - k + 1;
        if (nums.length <= k) size = 1;

        double[] results = new double[size];
        results[0] = getMedian(max, min);
        for (int i = k; i < nums.length; i++) {
            Element added = new Element(nums[i], i);
            deque.offerLast(added);
            Element removed = deque.pollFirst();
            removeValue(max, min, removed);
            addValue(max, min, added);
            reBalance(max, min);
            results[i - k + 1] = getMedian(max, min);
        }
        return results;
    }

    private double getMedian(TreeSet<Element> max, TreeSet<Element> min) {
        return (max.size() + min.size()) % 2 == 0 ? (max.first().value + min.first().value) / 2 : max.first().value;
    }

    private void addValue(TreeSet<Element> max, TreeSet<Element> min, Element e) {
        if (max.size() > 0 && max.first().value >= e.value) {
            max.add(e);
        } else if (min.size() > 0 && min.first().value < e.value){
            min.add(e);
        } else {
            max.add(e);
        }
    }

    private void removeValue(TreeSet<Element> max, TreeSet<Element> min, Element e) {
        if (max.contains(e)) max.remove(e);
        if (min.contains(e)) min.remove(e);
    }

    // trick -> rebalance the max and min to make sure
    //          1. max size is same as min size
    //          2. or max size is only one more than min size
    private void reBalance(TreeSet<Element> max, TreeSet<Element> min) {
        Element value = null;

        while (max.size() - min.size() >= 2) {
            value = max.first();
            max.remove(value);
            min.add(value);
        }

        while (min.size() > max.size()) {
            value = min.first();
            min.remove(value);
            max.add(value);
        }
    }
}
