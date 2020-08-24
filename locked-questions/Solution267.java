public class Solution {
    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
     */
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap();
        Set<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = map.getOrDefault(c, 0) + 1;
            map.put(c, num);

            if (num % 2 == 1) { 
                set.add(c);
            } else {
                set.remove(c);
            }
        }

        List<String> results = new ArrayList();
        if (set.size() >= 2) return results;
        
        if (set.size() == 1) {
            char key = set.iterator().next();
            if (map.get(key) - 1 == 0) {
                map.remove(key);
            } else {
                map.put(key, map.get(key) - 1);
            }
        }

        helper(map, set, "", map.size(), results);
        return results;
    }

    private void helper(Map<Character, Integer> map, Set<Character> set, String current, int size, List<String> results) {
        if (size == 0) {
            String result = null;
            if (set.size() == 0) {
                result = createPalindrome(current, current.length() - 1);
            } else {
                if (current.length() == 0) {
                    result = String.valueOf(set.iterator().next()); 
                } else {
                    result = createPalindrome(current + String.valueOf(set.iterator().next()), current.length() - 1);
                }
            }
            results.add(result);
            return;
        }

        for (char letter : map.keySet()) {
            int counter = map.get(letter);
            if (counter == 0) continue;
            int updatedCounter = counter - 2;
            int updatedSize = (updatedCounter == 0 ? size - 1 : size);
            map.put(letter, updatedCounter);
            helper(map, set, current + String.valueOf(letter), updatedSize, results);
            map.put(letter, counter);
        }
    }

    private String createPalindrome(String str, int endIndex) {
        StringBuilder sb = new StringBuilder(str);
        int index = endIndex;
        while (index >= 0) {
            sb.append(sb.charAt(index));
            index--;   
        }
        return sb.toString();
    }
}