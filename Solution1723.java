class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] result = new int[] { Integer.MAX_VALUE };
        int[] persons = new int[k];

        int max = 0;
        Arrays.sort(jobs);

        helper(jobs, jobs.length - 1, result, persons, max);
        return result[0];
    }

    private void helper(int[] jobs, int index, int[] result, int[] persons, int max) {
        if (index < 0) {
            result[0] = Math.min(max, result[0]);
            return;
        }

        // trick -> avoid branch if larger than previous result value
        if (max >= result[0]) return;

        int job = jobs[index];
        int preMax = max; 
        for (int i = 0; i < persons.length; i++) {
            // trick -> avoid lots of duplicated branches
            if (i > 0 && persons[i] == persons[i - 1]) continue;

            persons[i] += job;
            max = Math.max(persons[i], max);
            helper(jobs, index - 1, result, persons, max);
            max = preMax;
            persons[i] -= job;
        }
    }
}