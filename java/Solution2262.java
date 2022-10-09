class Solution {
    public long appealSum(String s) {
        // abbca
        // a -> 1 * 5 = 5
        // b -> 2 * 4 = 8
        // b -> 1 * 3 = 3 16
        // c -> 4 * 2 = 8 24
        // a -> 4 * 1 = 4 28

        // kttt
        // k -> 1 * 4 = 4
        // t -> 2 * 3 = 6
        // t -> 1 * 2 = 2
        // t -> 1 * 1 = 1

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
            letters[c - 'a'].add(i);
        }

        int length = s.length();
        for (int i = 0; i < letters.length; i++) {
            letters[i].add(length);
        }

        long result = 0;
        for (int i = 0; i < letters.length; i++) {
            List<Integer> indexes = letters[i];
            for (int j = 1; j < indexes.size() - 1; j++) {
                // trick -> this is the only difference between 828 and 2262
                //          when distinc, we will keep the most right letter in the result as distinc letter
                //          if there are multiple sames letters
                //          e.g. ab(1)b(2)c ->
                //               b(1) will contribute to -> xaxb(1)xb(2)xcx -> 2 * 3 = 6
                //               b(2) will contribute to -> ab(1)xb(2)xcx -> 1 * 2 = 2

                result += (long) (indexes.get(j) - indexes.get(j - 1)) * (long)(length - indexes.get(j));
            }
        }
        return result;
    }
}
