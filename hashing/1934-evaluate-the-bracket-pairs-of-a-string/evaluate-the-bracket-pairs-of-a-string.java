class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            hm.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                String key = "";
                int j = i + 1;
                while (j < s.length() && s.charAt(j) != ')')
                    key += s.charAt(j++);
                i = j;
                String value = hm.get(key) == null ? "?" : hm.get(key);
                sb.append(value);
            } else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}