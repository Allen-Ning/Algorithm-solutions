class TopVotedCandidate {

    int[] winners;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.winners = new int[times.length];

        HashMap<Integer, Integer> map = new HashMap();
        int maxVote = -1;
        int maxVotePerson = -1;
        for (int i = 0; i< persons.length; i++) {
            int person = persons[i];
            int vote = map.getOrDefault(person, 0) + 1;
            map.put(person, vote);

            if (vote >= maxVote) {
                maxVote = vote;
                winners[i] = person;
                maxVotePerson = person;
            } else {
                winners[i] = maxVotePerson;
            }
        }
    }

    public int q(int t) {
        int index = binarySearch(t);
        return this.winners[index];
    }

    private int binarySearch(int time) {
        int low = -1;
        int high = this.times.length;

        while (low + 1 != high) {
            int mid = low + (high - low) / 2;
            if (this.times[mid] == time) {
                return mid;
            } else if (this.times[mid] < time) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */