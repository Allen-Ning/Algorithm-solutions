public class ZigzagIterator {
    List<Integer> v1;
    List<Integer> v2;
    int p1;
    int p2;
    // two available values [0, 1]
    int order;

    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.p1 = 0;
        this.p2 = 0;
        this.order = 0;
    }

    /*
     * @return: An integer
     */
    public int next() {
        if(!hasNext()) return -1;

        if (order == 0 && p1 < v1.size()) {
            order = 1;
            return v1.get(p1++);
        } else if (order == 0 && p1 >= v1.size()) {
            order = 1;
            return v2.get(p2++);
        } else if (order == 1 && p2 >= v2.size()) {
            order = 0;
            return v1.get(p1++);
        } else if (order == 1 && p2 < v2.size()) {
            order = 0;
            return v2.get(p2++);
        } else {
            return -1;
        }
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        if (p1 < v1.size() || p2 < v2.size()) return true;
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */