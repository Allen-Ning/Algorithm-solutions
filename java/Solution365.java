class Solution {
    // trick -> this is pure math question
    //          there must existing x, y which leads to ax + by = d (d is gcd of a, b) a != 0, b != 0
    //          so that we need to check if z % d == 0
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0 && y == 0 && z == 0) return true;
        if (z >= 0 && z <= x + y && z % gcd(x,y) == 0) return true;
        return false;
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y); 
    }
}
