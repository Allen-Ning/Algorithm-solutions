class Solution {
    public String reformatDate(String date) {
        HashMap<String, String> map = new HashMap();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");

        String[] values = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(values[2]);
        sb.append("-");
        sb.append(map.get(values[1]));
        sb.append("-");

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < values[0].length(); i++) {
            char c = values[0].charAt(i);
            if (c < '0' || c > '9') break;
            sb2.append(c);
        }

        if (sb2.length() == 1) sb.append("0");
        return sb.toString() + sb2.toString();
    }
}