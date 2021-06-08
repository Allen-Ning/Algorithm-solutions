class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> results = new ArrayList();

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        while (index1 < arr1.length &&
               index2 < arr2.length &&
               index3 < arr3.length
              ) {
            int value1 = arr1[index1];
            int value2 = arr2[index2];
            int value3 = arr3[index3];

            if (value1 == value2 && value2 == value3) {
                results.add(value1);
                index1++;
                index2++;
                index3++;
            } else {
                int min = Math.min(value1, Math.min(value2, value3));
                if (value1 == min) index1++;

                if (value2 == min) index2++;

                if (value3 == min) index3++;
            }
        }
        return results;
    }
}