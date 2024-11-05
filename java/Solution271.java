public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            sb.append(len + "_" + str);
        }
        return sb.toString();
    }

    /**
        e.g. 5_Hello5_World
     */
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int length = s.length();
        while (start < length) {
            int num = 0;
            while (s.charAt(start) != '_') {
                int val = s.charAt(start) - '0';
                num = num * 10 + val;
                start++;
            } 

            start++;
            sb = new StringBuilder();
            while (num > 0) {
                sb.append(s.charAt(start++));
                num--;
            }
            result.add(sb.toString());
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));