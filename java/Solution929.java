class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;

        Set<String> set = new HashSet();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] splitByPlus = parts[0].split("\\+");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < splitByPlus[0].length(); i++) {
                if (splitByPlus[0].charAt(i) != '.') sb.append(splitByPlus[0].charAt(i));
            }
            sb.append("@");
            sb.append(parts[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}
