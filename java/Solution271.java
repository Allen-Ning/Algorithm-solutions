public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();

        int index = 0;
        int size = 0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '/') {
                if (size == 0) sb.append("");
                while (size > 0) {
                    sb.append(s.charAt(index + 1));
                    index++;
                    size--;
                }
                result.add(sb.toString());
                // trick -> this setLenght method is to clear StringBuilder object
                sb.setLength(0);
            } else {
                size = size * 10 + (c - '0');
            }
            index++;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));