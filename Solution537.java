class Solution {
    public String complexNumberMultiply(String a, String b) {
        // trick -> The input strings will be given in the form of a+bi
        String[] data1 = a.split("\\+");
        String[] data2 = b.split("\\+");
        int num1 = Integer.valueOf(data1[0]);
        int num2 = Integer.valueOf(data1[1].split("i")[0]);
        int num3 = Integer.valueOf(data2[0]);
        int num4 = Integer.valueOf(data2[1].split("i")[0]);
        int partA = num1 * num3 + num2 * num4 * (-1);
        int partB = num1 * num4 + num2 * num3;
        return partA + "+" + partB + "i";
    }
}
