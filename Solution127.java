class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        // trick -> double-end bfs
        Set<String> startSet = new HashSet();
        Set<String> endSet = new HashSet();
        Set<String> checked = new HashSet();
        for (String str : wordList) checked.add(str);

        startSet.add(beginWord);
        // trick -> endWord must in wordlist
        if (checked.contains(endWord)) endSet.add(endWord);
        Set<String> visited = new HashSet();
        int step = 1;
        while (startSet.size() > 0 && endSet.size() > 0) {
            // trick -> only use the smaller set as the startSet
            if (startSet.size() > endSet.size()) {
                Set<String> set = startSet;
                startSet = endSet;
                endSet = set;
            }

            // trick -> need to create a new set for each run
            Set<String> temp = new HashSet();
            StringBuilder sb = null;
            for (String str : startSet) {
                for (int i = 0; i < str.length(); i++) {
                    sb = new StringBuilder(str);
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(i, j);
                        String newValue = sb.toString();
                        if (endSet.contains(newValue)) return step + 1;
                        if (checked.contains(newValue) && visited.add(newValue)) temp.add(newValue);
                    }
                }
            }
            startSet = temp;
            step++;
        }
        return 0;
    }
}
