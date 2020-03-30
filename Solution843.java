/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        // trick -> build a hashmap to records (key: word, value: number of 0 matched words)
        Map<String, Integer> map = new HashMap();
        for (String word1 : wordlist) {
            for (String word2 : wordlist) {
                if (match(word1, word2) == 0) map.put(word1, map.getOrDefault(word1, 0) + 1);
            }
        }

        String[] checkedList = wordlist;
        int min = Integer.MAX_VALUE;
        String guessWord = checkedList[0];
        for (int i = 0; i < 10; i++) {
            guessWord = checkedList[0];
            // trick -> find the word with minimium 0 match
            //          the word with minimium 0 match will be using for guessWord
            //          due to the fact that (25/26)^6 around 80% chances is that
            //          a word has 80% opportunity with 0 match against secret
            //          End goal:  we need to try to hit the 80% chances by the finding
            //                     the word with mininium 0 matched words
            for (String word : checkedList) {
                if (map.containsKey(word) && map.get(word) < min) {
                    min = map.get(word);
                    guessWord = word;
                }
            }

            int matchNum = master.guess(guessWord);
            if (matchNum == 6) return;

            List<String> newList = new ArrayList();
            // trick -> find all the all words has the same matchedNum as secrets
            //          and then put all those words to newLists for next checking
            for (String word : checkedList) {
                if (!word.equals(guessWord) && match(word, guessWord) == matchNum) newList.add(word);
            }

            checkedList = newList.toArray(new String[newList.size()]);
        }
    }

    private int match(String str1, String str2) {
        int counter = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) counter++;
        }
        return counter;
    }
}
