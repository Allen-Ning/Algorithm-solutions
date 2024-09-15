class Solution {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) numbers[i] = String.valueOf(nums[i]);

        Arrays.sort(numbers, (a, b) -> compare(a, b));

        StringBuilder sb = new StringBuilder();
        if (numbers[0].equals("0")) return numbers[0];
        for (String num : numbers) sb.append(num);
        return sb.toString();
    }
    // [30, 3]
    // num1 3
    // num2 30
    // concat 1 = 303
    // concat 2 =  330
    // -1
    // [3, 30]

    // [3, 30]
    // num1 30
    // num2 3
    // concat 1 = 330
    // concat 2 = 303
    // 1
    private int compare(String a, String b) {
        // e.g a -> 10, b -> 2
        // 102
        String result1 = a + b;

        // 210
        String result2 = b + a;

        return result2.compareTo(result1);
    }
}
