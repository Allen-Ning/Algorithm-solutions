class Solution {
    public int uniqueLetterString(String s) {
        // e.g.
        //  ABC
        // A 1 * 3 = 3
        // B 2 * 2 = 4
        // c 3 * 1 = 3

        // A B A
        // A 1 * 2 = 2
        // B 2 * 2 = 4
        // A 2 * 1 = 2

        List<Integer>[] letters = new List[26];
        // trick -> we cannot use arrays.fill
        //          cos it will fill the same arraylist in the array for every elements
        // Arrays.fill(letters, new ArrayList())

        for (int i = 0; i < 26; i++) {
            List<Integer> list = letters[i];
            list = new ArrayList();
            list.add(-1);
            letters[i] = list;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'A'].add(i);
        }

        int length = s.length();
        for (int i = 0; i < letters.length; i++) {
            letters[i].add(length);
        }

        int result = 0;
        for (int i = 0; i < letters.length; i++) {
            List<Integer> indexes = letters[i];
            for (int j = 1; j < indexes.size() - 1; j++) {
                result += (indexes.get(j) - indexes.get(j - 1)) * (indexes.get(j + 1)- indexes.get(j));
            }
        }
        return result;
    }
}