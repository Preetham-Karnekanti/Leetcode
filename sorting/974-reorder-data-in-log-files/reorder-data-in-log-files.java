class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letterLogs = new ArrayList<>();
        ArrayList<String> digitLogs = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            if (isDigitLog(logs[i]))
                digitLogs.add(logs[i]);
            else
                letterLogs.add(logs[i]);
        }
        Collections.sort(letterLogs, (a, b) -> {
            String id = a.substring(0, a.indexOf(" "));
            String content = a.substring(a.indexOf(" ") + 1);

            String id1 = b.substring(0, b.indexOf(" "));
            String content1 = b.substring(b.indexOf(" ") + 1);

            if (content.equals(content1)) {
                return id.compareTo(id1);
            } else {
                return content.compareTo(content1);
            }
        });
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }

    public boolean isDigitLog(String str) {
        char ch = str.charAt(str.length() - 1);
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }
}