class Solution2 {

    List<Integer> list;
    Set<Integer> set;

    public TwoSum() {
        this.list = new ArrayList();
        this.set = new HashSet();
    }

    // o (n)
    public void add(int number) {
        for (int num : list) set.add(num + number);

        list.add(number);
    }

    // o (1)
    public boolean find(int value) {
        return set.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */