class Solution {
    public int[] arrayRankTransform(int[] arr) {        
        int[] results = new int[arr.length];
        for (int i = 0; i < arr.length; i++) results[i] = arr[i];

        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap();
        int counter = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i - 1 >= 0 && arr[i] > arr[i - 1]) counter++;
            map.put(arr[i], counter);
        }

        for (int i = 0; i < results.length; i++) results[i] = map.get(results[i]);

        return results;
    }
}