class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap();
        int mod = (int)1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], (long)1);
        }

        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[i] % arr[j] != 0) continue;

                int lookup = arr[i] / arr[j];
                if (!map.containsKey(lookup)) continue;

                long value = (map.get(arr[i]) + map.get(arr[j]) * map.get(lookup)) % mod;
                map.put(arr[i], value);
            }
            result += map.get(arr[i]);
            result %= mod;
        }
        return (int)result;
    }