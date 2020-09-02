public class Solution extends Relation {
    public int findCelebrity(int n) {
        int potentialCelebrity = 0;
        for (int i = 0; i < n; i++) {
            // trick -> If i knows potentialCelebrity, which means i is not celebrity. If i does not know potentialCelebrity, potentialCelebrity is not celebrity and i could be celebrity
            if (!knows(i, potentialCelebrity)) potentialCelebrity = i;
        }

        for (int i = 0; i < n; i++) {
            if (i == potentialCelebrity) continue;
            // trick -> double check if potentialCelebrity is celebrity
            if (!knows(i, potentialCelebrity) || knows(potentialCelebrity, i)) return -1;
        }
        return potentialCelebrity;
    }
}
