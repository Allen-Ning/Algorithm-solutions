class FileSystem {

    Directory root;

    public FileSystem() {
        this.root = new Directory("/");
    }

    public List<String> ls(String path) {
        Directory current = this.root;
        String[] identifiers = path.split("/");
        for (int i = 0; i < identifiers.length - 1; i++) {
            if (identifiers[i].length() == 0) continue;

            String indentifier = identifiers[i];
            current = current.subDirectories.get(indentifier);
        }

        boolean isDirectory = false;
        boolean isFile = false;
        String identifier = "";
        List<String> result = new ArrayList();
        if (identifiers.length == 0) {
            for (String subDirName : current.subDirectories.keySet()) result.add(subDirName);
            for (String subFileName : current.files.keySet()) result.add(subFileName);
            Collections.sort(result);
            return result;
        }

        identifier = identifiers[identifiers.length - 1];
        isDirectory = current.subDirectories.get(identifier) != null;
        isFile = current.files.get(identifier) != null;

        if (isDirectory) {
            current = current.subDirectories.get(identifier);
            for (String subDirName : current.subDirectories.keySet()) result.add(subDirName);
            for (String subFileName : current.files.keySet()) result.add(subFileName);
            Collections.sort(result);
        } else if (isFile) {
            result.add(identifier);
        }
        return result;
    }

    public void mkdir(String path) {
        Directory current = this.root;
        for (String indentifier : path.split("/")) {
            if (indentifier.length() == 0) continue;

            Directory directory = current.subDirectories.get(indentifier);
            if (directory == null) {
                directory = new Directory(indentifier);
                current.subDirectories.put(indentifier, directory);
            }
            current = directory;
        }
    }

    public void addContentToFile(String filePath, String content) {
        Directory current = this.root;
        String[] identifiers = filePath.split("/");
        for (int i = 0; i < identifiers.length - 1; i++) {
            if (identifiers[i].length() == 0) continue;

            String indentifier = identifiers[i];
            current = current.subDirectories.get(indentifier);
        }

        String fileName = identifiers[identifiers.length - 1];
        File file = current.files.getOrDefault(fileName, new File(fileName, ""));
        file.content += content;
        current.files.put(fileName, file);
    }

    public String readContentFromFile(String filePath) {
        Directory current = this.root;
        String[] identifiers = filePath.split("/");
        for (int i = 0; i < identifiers.length - 1; i++) {
            if (identifiers[i].length() == 0) continue;

            String indentifier = identifiers[i];
            current = current.subDirectories.get(indentifier);
        }

        String fileName = identifiers[identifiers.length - 1];
        File file = current.files.getOrDefault(fileName, new File(fileName, ""));
        return file.content;
    }

    class Directory {
        String name;
        HashMap<String, Directory> subDirectories;
        HashMap<String, File> files;

        public Directory(String name) {
            this.name = name;
            this.subDirectories = new HashMap();
            this.files = new HashMap();
        }
    }

    class File {
        String name;
        String content;

        public File(String name, String content) {
            this.name = name;
            this.content = content;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */