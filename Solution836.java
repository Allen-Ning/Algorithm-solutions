class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // trick -> total 6 different cases
        //          1. top left overlap
        //          2. top right overlap
        //          3. bottom left overlap
        //          4. bottom right overlap
        //          5. rec1 inside rec2
        //          6. rec2 inside rec1

        // trick -> must follow this rule
        // (x1, y1) in the left bottom direction of (x4, y4)
        // (x3, y3) in the left bottom direction of (x2, y2)
        if (rec1[0] < rec2[2] &&
            rec1[1] < rec2[3] &&
            rec1[2] > rec2[0] &&
            rec1[3] > rec2[1]
           ) return true;
        return false;
    }
}
