class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        // height from 1 to n
        int height = (int) Math.ceil(Math.log(label + 1) / Math.log(2));
        List<Integer> results = new ArrayList();

        // trick -> only when height is even, directly add it in
        //          this implementation is different from the best voted solution
        //          but I think this is easy enough to understand 
        //          and have the same time complexity log(n)
        if (height % 2 == 0) {
            results.add(label);
            label /= 2;
            height--;
            label = replace(label, height);
        }

        while (height > 0) {
            int displayLabel = height % 2 == 0 ? replace(label, height) : label;
            results.add(displayLabel);
            label /= 2;
            height--;
        }

        Collections.reverse(results);
        return results;
    }

    private int replace(int label, int height) {
        int startLabel = (int) Math.pow(2, height - 1);
        int lastLabel = (int) Math.pow(2, height) - 1;
        int newLable = lastLabel - label + startLabel;
        return newLable;
    }
}
