class Solution {
    // trick -> check sx, sy , tx, ty whehter equals to zero for % operation
    //          to avoid error java.lang.ArithmeticException: / by zero
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return true;
        if (sx == tx && sy < ty) return sx == 0 ? false : (ty - sy) % sx == 0;
        if (sx < tx && sy == ty) return sy == 0 ? false : (tx - sx) % sy == 0;

        if (ty > tx) {
            return tx == 0 ? false : reachingPoints(sx, sy, tx, ty % tx);
        } else if (ty < tx) {
            return ty == 0 ? false : reachingPoints(sx, sy, tx % ty, ty);
        } else {
            return false;
        }
    }
}
