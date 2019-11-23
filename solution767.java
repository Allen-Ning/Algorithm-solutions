class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) return "";
        int[] letters = new int[26];
        for (int i = 0; i < S.length(); i++) letters[S.charAt(i) - 'a'] += 1;

        // trick -> this is descending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) pq.offer(new int[] {i, letters[i]});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();

             // trick -> this is to make sure the first element has been added in as the last step
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == (first[0] + 'a')) {
                int[] second = pq.poll();
                if (second == null) return "";
                sb.append((char)(second[0] + 'a'));
                if (--second[1] > 0) pq.offer(second);
                pq.offer(first);
            } else {
                sb.append((char)(first[0] + 'a'));
                if (--first[1] > 0) pq.offer(first);
            }
        }
        return sb.toString();
    }
}
