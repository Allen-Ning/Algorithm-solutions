class Solution {
    // soluton -> double-end bfs (find the minimium steps and build neighbours map) + dfs (find all the possible solutions)
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> checked = new HashSet();
        for (String str : wordList) checked.add(str);
        HashMap<String, Set<String>> neighbours = new HashMap();
        int minLength = ladderLength(beginWord, endWord, checked, neighbours);
        List<List<String>> list = new ArrayList();
        if (minLength == 0) return list;
        Set<String> visited = new HashSet();
        List<String> result = new ArrayList<String>();
        visited.add(beginWord);
        result.add(beginWord);
        helper(list, minLength, 1, beginWord, endWord, checked, visited, neighbours, result);
        return list;
    }

    private void helper(List<List<String>> list, int minLength, int currentStep, String current, String endWord, Set<String> checked, Set<String> visited, HashMap<String, Set<String>> neighbours, List<String> result) {
        if (currentStep > minLength) return;

        if (current.equals(endWord)) {
            list.add(new ArrayList<String>(result));
            return;
        }

        if (neighbours.get(current) == null) return;

        for (String neighbour : neighbours.get(current)) {
            if (visited.contains(neighbour)) continue;
            visited.add(neighbour);
            result.add(neighbour);
            helper(list, minLength, currentStep + 1, neighbour, endWord, checked, visited, neighbours, result);
            visited.remove(neighbour);
            result.remove(result.size() - 1);
        }
    }

    private int ladderLength(String beginWord, String endWord, Set<String> checked,  HashMap<String, Set<String>> neighbours) {
        if (beginWord.equals(endWord)) return 0;
        // trick -> double-end bfs
        Set<String> startSet = new HashSet();
        Set<String> endSet = new HashSet();

        startSet.add(beginWord);
        // trick -> endWord must in wordlist
        if (checked.contains(endWord)) endSet.add(endWord);
        Set<String> visited = new HashSet();
        int step = 1;

        boolean flip = false;
        boolean isDone = false;
        while (startSet.size() > 0 && endSet.size() > 0) {

            if (isDone) break;
            // trick -> only use the smaller set as the startSet
            if (startSet.size() > endSet.size()) {
                Set<String> set = startSet;
                startSet = endSet;
                endSet = set;
                flip = !flip;
            }

            // super trick -> needs to do this to remove all the visited nodes
            //                this will increase the speed to code due to smaller neighbours map
            checked.removeAll(startSet);

            // trick -> need to create a new set for each run
            Set<String> temp = new HashSet();
            StringBuilder sb = null;
            for (String str : startSet) {
                for (int i = 0; i < str.length(); i++) {
                    sb = new StringBuilder(str);
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(i, j);
                        String newValue = sb.toString();
                        if (newValue.equals(str)) continue;
                        if (!checked.contains(newValue)) continue;

                        // trick -> this code to make sure the neighbours map build in the right direction
                        String key = flip ? newValue: str;
                        String value = flip ? str : newValue;
                        Set<String> set = neighbours.getOrDefault(key, new HashSet<String>());
                        set.add(value);
                        neighbours.put(key, set);

                        if (endSet.contains(newValue)) {
                            isDone = true;
                        } else {
                            temp.add(newValue);
                        }
                    }
                }
            }
            startSet = temp;
            step++;
        }
        if (isDone) return step;
        return 0;
    }
}
