class Solution {
    // category: greedy
    // corner case:
    //  1. [0] 7
    //  2. huge data for damages overflow -> must use long
    //  3. [3, 7] 4 -> 4 matches with 7 rather than 3
    public long minimumHealth(int[] damages, int armor) {
        long total = 1;
        int max = 0;
        for (int damage : damages) {
            total += damage;
            max = Math.max(max, damage);
        }

        return total - Math.min(armor, max);
    }
}