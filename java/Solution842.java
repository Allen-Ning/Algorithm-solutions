class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList();
        if (helper(list, S, 0)) return list;
        return new ArrayList();
    }

    private boolean helper(List<Integer> list, String s, int start) {
        if (start >= s.length()) {
            return list.size() > 2 ? true : false;
        }

        int size = list.size();
        long lookupValue = 0;
        if (size >= 2) lookupValue = list.get(size - 1) + list.get(size - 2);

        long value = 0;
        for (int i = start; i < s.length(); i++) {
            value = value * 10 + s.charAt(i) - '0';

            if (value > Integer.MAX_VALUE) return false;
            if (size >= 2 && lookupValue > value) continue;
            if (size >= 2 && lookupValue < value) return false;

            // leading zero
            if (value == 0) {
                list.add(0);
                if (helper(list, s, start + 1)) return true;
                list.remove(list.size() - 1);
                return false;
            }

            list.add((int) value);
            if (helper(list, s, i + 1)) return true;
            list.remove(list.size() - 1);
        }
        return false;
    }
}
