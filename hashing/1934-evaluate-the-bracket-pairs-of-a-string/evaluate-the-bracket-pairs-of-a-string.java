class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        char[] ch = s.toCharArray();
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            hm.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (ch[i] == '(') {
                StringBuilder key = new StringBuilder();
                int j = i + 1;
                while (j < n && ch[j] != ')')
                    key.append(ch[j++]);
                i = j;
                String value = hm.get(key.toString()) == null ? "?" : hm.get(key.toString());
                sb.append(value);
            } else
                sb.append(ch[i]);
        }
        return sb.toString();
    }
}