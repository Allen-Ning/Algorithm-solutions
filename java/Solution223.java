class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.abs(A - C); 
        int y1 = Math.abs(B - D);
        int x2 = Math.abs(E - G);
        int y2 = Math.abs(H - F);
        int left = Math.max(B, F);
        int right = Math.min(D, H);
        int top = Math.min(C, G);
        int bottom = Math.max(A, E);
        int opX = Math.min(C, G) - Math.max(A, E);
        int opY = Math.min(D, H) - Math.max(B, F);

        int result = x1 * y1 + x2 * y2;
        if (left <= right && top >= bottom) {
            result -=  opX * opY;
        }
        return result;
    }
}
