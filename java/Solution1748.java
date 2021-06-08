class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();

        int total = 0;
        for (int num : nums) {
            int size = map.getOrDefault(num, 0);
            if (size == 0) {
                total += num;
            } else if (size == 1) {
                total -= num;
            }
            map.put(num, size + 1);
        }
        return total;
    }
}