class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return false;
        String[] array = preorder.split(",");
        int degree = 1;
        for (int i = 0; i < array.length; i++) {
            degree--;
            if (degree < 0) return false;
            if (!array[i].trim().equals("#")) degree += 2;
        }
        return degree == 0;
    }
}
