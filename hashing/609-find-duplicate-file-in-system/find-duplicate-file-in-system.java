class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : paths) {
            String dir = getDirectory(str);
            String files[] = getFiles(str);
            for (int i = 0; i < files.length; i++) {
                String[] nameAndContent = getFileAndContent(files[i]);
                String name = nameAndContent[0];
                String content = nameAndContent[1];
                hm.putIfAbsent(content, new ArrayList<>());
                hm.get(content).add(dir + "/" + name);
            }
        }

        return hm.values().stream().filter(x -> x.size() > 1).toList();
    }

    public String getDirectory(String str) {
        return str.split(" ")[0];
    }

    public String[] getFiles(String str) {
        String arr[] = str.split(" ");
        String files[] = new String[arr.length - 1];
        for (int i = 1; i < arr.length; i++)
            files[i - 1] = arr[i];
        return files;
    }

    public String[] getFileAndContent(String str) {
        int idx = str.indexOf('(');
        String fileName = str.substring(0, idx);
        String content = str.substring(idx + 1, str.length() - 1);
        return new String[] { fileName, content };
    }
}
