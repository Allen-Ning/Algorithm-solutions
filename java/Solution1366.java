class Solution {
    public String rankTeams(String[] votes) {
        Element[] list = new Element[26];

        for (String vote : votes) {
            int length = vote.length();
            for (int i = 0; i < length; i++) {
                char c = vote.charAt(i);
                Element element = list[c - 'A'];
                if (element == null) element = new Element(c, new int[26]);
                element.frequences[i] += 1;
                list[c - 'A'] = element;
            }
        }

        // trick -> sort by using loop
        Arrays.sort(list, (e1, e2) -> {
            if (e1 == null) return 1;
            if (e2 == null) return -1;
            for (int i = 0; i < 26; i++) {
                if (e1.frequences[i] == e2.frequences[i]) continue;
                return e2.frequences[i] - e1.frequences[i];
            }
            return e1.c - e2.c;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) break;
            sb.append(list[i].c);
        }
        return sb.toString();
    }

    class Element {
        char c;
        int[] frequences;
            
        public Element(char c, int[] frequences) {
            this.c = c;
            this.frequences = frequences;
        }
    }
}