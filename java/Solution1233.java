class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList();
        for (int i = 0; i < folder.length; i++) {
            String current = folder[i];
            int j = i + 1;
            while (j < folder.length) {
                String next = folder[j];
                // trick -> need to add "/" to avoid special test case
                //          ["/a/b/c","/a/b/ca","/a/b/d"]
                if (!next.startsWith(current + "/")) break;
                j++;
            }
            list.add(current);
            i = j - 1;
        }
        return list;
    }
}