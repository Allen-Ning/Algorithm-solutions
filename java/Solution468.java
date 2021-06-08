class Solution {
    public String validIPAddress(String IP) {
        if (IP.contains(".") && checkIpV4(IP)) {
            return "IPv4";
        } else if (IP.contains(":") && checkIpV6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean checkIpV4(String str) {
        String[] parts = str.split("\\.");

        if (str.charAt(str.length() - 1) == '.') return false;
        if (parts.length != 4) return false;
        int num = 0;
        for (String part: parts) {
            // trick -> handle specail case like '123..12.12.12'
            if (part.length() == 0) return false;
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (c < '0' || c > '9') return false;
                num = num * 10 + c - '0';
            }
            if (num > 255) return false;
            String num_str = num + "";
            if (part.length() > num_str.length()) return false;
            num = 0;
        }
        return true;
    }

    private boolean checkIpV6(String str) {
        String[] parts = str.split(":");
        if (parts.length != 8) return false;

        int num = 0;
        // trick -> handle specail case like '2001:0db8:85a3:0:0:8A2E:0370:7334:'
        if (str.charAt(str.length() - 1) == ':') return false;
        for (String part : parts) {
            String lowerCasePart = part.toLowerCase();
            if (lowerCasePart.length() > 4 || lowerCasePart.length() == 0) return false;
            for (int i = 0; i < lowerCasePart.length(); i++) {
                char c = lowerCasePart.charAt(i);
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                } else if (c >= 'a' && c <= 'f') {
                    num = 0;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
