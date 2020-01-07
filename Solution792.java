class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0) return 0;

        HashMap<Character, List<Integer>> map = new HashMap();
        for (int i = 0; i < S.length(); i++) {
            List<Integer> list = map.getOrDefault(S.charAt(i), new ArrayList());
            list.add(i);
            map.put(S.charAt(i), list);
        }

        int result = 0;
        for (String word : words) {
            int index = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) break;
                List<Integer> list = map.get(c);
                int lowIndex = findLowerBound(list, index + 1);
                index = lowIndex;
                if (index == -1) break;
                if (i == word.length() - 1) result++;
            }
        }
        return result;
    }

    private int findLowerBound(List<Integer> list, int index) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == index) return list.get(mid);

            if (list.get(mid) < index) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low == list.size() ? -1 : list.get(low);
    }
}
