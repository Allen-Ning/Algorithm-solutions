class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap();
        for (String path : paths) {
            String[] data = path.split(" ");
            String directory = data[0];
            for (int i = 1; i < data.length; i++) {
                String[] fileNameAndContent = splitFileNameAndContent(data[i]);
                String fileName = fileNameAndContent[0];
                String content = fileNameAndContent[1];
                String value = directory + "/" + fileName;
                List<String> list = map.getOrDefault(content, new ArrayList());
                list.add(value);
                map.put(content, list);
            }
        }

        List<List<String>> results = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) results.add(entry.getValue());
        }
        return results;
    }

    private String[] splitFileNameAndContent(String str) {
        int position = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                position = i;
                break;
            }
        }
        return new String[] { str.substring(0, position), str.substring(position) };
    }
}
