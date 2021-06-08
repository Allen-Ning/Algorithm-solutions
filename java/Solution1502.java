class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) return true;

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet();
        for (int value : arr) {
            set.add(value);
            max = Math.max(max, value);
            if (value < min) {
                secondMin = min;
                min = value;
            } else {
                secondMin = Math.min(value, secondMin);
            }
        }

        int gap = secondMin - min;
        int checkValue = min;
        int counter = 1;
        while (counter < arr.length) {
            if (!set.contains(checkValue)) return false;
            checkValue += gap;
            counter++;
        }

        // trick -> this is to avoid gap 0 to check if max is finally reached
        if (checkValue != max) return false;
        return true; 
    }
}
