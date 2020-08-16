public class Vector2D implements Iterator<Integer> {

    int listIndex = 0;
    int elementIndex = 0;
    List<List<Integer>> lists;
    public Vector2D(List<List<Integer>> vec2d) {
        // trick -> this is to avoid empty list such as [[], [1, 2], []]
        int i = 0;
        while (i < vec2d.size()) {
            if (vec2d.get(i).size() == 0) {
                vec2d.remove(i);
                continue;
            }
            i++;
        }
        this.lists = vec2d;
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        List<Integer> list = lists.get(this.listIndex);
        Integer result = list.get(this.elementIndex);
        this.elementIndex += 1;
        if (this.elementIndex >= list.size()) {
            this.elementIndex = 0;
            this.listIndex++;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (listIndex >= lists.size()) return false;
        List<Integer> list = lists.get(listIndex);
        if (elementIndex >= list.size()) return false;
        return true;
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
