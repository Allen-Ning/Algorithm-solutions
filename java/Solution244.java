class WordDistance {
    HashMap<String, List<Integer>> map;
    int length;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap();
        this.length = wordsDict.length;

        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            List<Integer> list = map.getOrDefault(word, new ArrayList());
            list.add(i);
            map.put(word, list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int result = length;
        int index1 = 0;
        int index2 = 0;
        int size1 = list1.size();
        int size2 = list2.size();
        while (index1 < size1 && index2 < size2) {
            int value1 = list1.get(index1);
            int value2 = list2.get(index2);

            if (value1 < value2) {
                result = Math.min(result, value2 - value1);
                index1++;
            } else {
                result = Math.min(result, value1 - value2);
                index2++;
            }
        }

        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */