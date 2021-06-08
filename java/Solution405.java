class Solution {
    public String toHex(int num) {  
        if (num == 0) return "0";
        char[] values = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        // trick -> when num is zero there is no need to add any value
        while (counter < 8 && num != 0) {
            // trick -> this is bit manipulation problem
            //          -1 will be 11111111111111111111111111111111 
            sb.append(values[num & 15]);
            // trick -> >>> is needed
            //          https://stackoverflow.com/questions/2811319/difference-between-and
            num = num >>> 4;
            counter++;
        }
        return sb.reverse().toString();
    }
}
