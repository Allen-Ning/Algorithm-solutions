public class Solution {
    public String alienOrder(String[] words) {
        Set<Character>[] map = new Set[26];
        int[] indegrees = new int[26];
        Arrays.fill(indegrees, -1);

        // trick -> letters are being used
        boolean[] availableLetters = new boolean[26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) availableLetters[c - 'a'] = true;

            if (i < words.length - 1) {
                boolean isOk = compare(map, indegrees, words[i], words[i + 1]);
                // trick -> invalid rules exist, directly return ""
                if (!isOk) return "";
            }
        }

        Queue<Character> queue = new LinkedList();
        boolean hasRule = false;
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == -1) continue;

            hasRule = true;
            if (indegrees[i] == 0) queue.offer((char) (i + 'a'));
        }

        // trick -> if have dependencies, but no available to start
        //          e.g. such as a -> b and b -> a, both of a and b are 1 as indegress
        if (hasRule && queue.size() == 0) return "";

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 0) {
            char c = queue.poll();
            availableLetters[c - 'a'] = false;
            sb.append(c);
            Set<Character> set = map[c - 'a'];
            if (set == null || set.size() == 0) continue;
            for (char next : set) {
                indegrees[next - 'a'] -= 1;
                if (indegrees[next - 'a'] == 0) queue.offer(next);
            }
        }

        // trick -> this is for inserting the result with alphabetical order for those chars without rules
        for (int i = 0; i < availableLetters.length; i++) {
            if (!availableLetters[i]) continue;
            if (sb.length() == 0) {
                sb.append((char) (i + 'a'));
                continue;
            }

            for (int j = 0; j < sb.length(); j++) {
                if (i + 'a' < sb.charAt(j)) {
                    sb.insert(j, (char) (i + 'a'));
                    break;
                }

                if (j == sb.length() - 1 && i + 'a' > sb.charAt(j)) {
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }

    private boolean compare(Set<Character>[] map, int[] indegrees, String str1, String str2) {
        int length = str1.length();
        for (int i = 0; i < length; i++) {
            char c1 = str1.charAt(i);
            char c2 = ' ';
            if (i < str2.length()) c2 = str2.charAt(i);

            // trick -> c2 is shorter than c1, this is invalid rules
            if (c2 == ' ') return false;

            if (c1 != c2) {
                Set<Character> set = map[c1 - 'a'];
                if (set == null) set = new HashSet();
                set.add(c2);
                // c1 -> c2
                map[c1 - 'a'] = set;

                // trick -> this indicates c1, c2 have dependencies
                if (indegrees[c1 - 'a'] == -1) indegrees[c1 - 'a'] = 0;
                if (indegrees[c2 - 'a'] == -1) indegrees[c2 - 'a'] = 0;
                indegrees[c2 - 'a'] += 1;
                break;
            }
        }
        return true;
    }
}i