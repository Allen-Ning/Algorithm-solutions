class Solution {
    // index  012345
    // n      230241
    // array  142032
    // swop   124032
    // order  214032
    // result 230412
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        int index = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= list.get(i + 1)) continue;
            index = i + 1;
            break;
        }
        if (index == -1) return -1;

        // find swop index
        int swopIndex = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            int diff = list.get(i) - list.get(index);
            if (diff > 0 && diff < minDiff) {
                swopIndex = i;
                minDiff = diff;
            }
        }
        swop(list, index, swopIndex);

        // sort index from 0 to index -1;
        Collections.sort(list.subList(0,index), (a,b) -> Integer.compare(b, a));

        // trick -> this is for handle specail case
        //          e.g. 1999999999
        //          after change 9199999999 overflow
        long result = 0;   
        for (int i = list.size() - 1; i >= 0; i--) result = 10 * result + list.get(i);
        return result > Integer.MAX_VALUE ?  -1 : (int) result;
    }

    private void swop(List<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
