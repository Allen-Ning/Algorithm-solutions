class Solution {
    // just a trick question by using greedy
    public boolean canWinNim(int n) {
        return n % 4 == 0 ? false : true;
    }
}
