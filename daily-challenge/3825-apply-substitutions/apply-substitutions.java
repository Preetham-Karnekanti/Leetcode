class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < replacements.size(); i++) {
            String key = replacements.get(i).get(0);
            String value = replacements.get(i).get(1);
            hm.put(key, value);
        }

        return dfs(text, hm);
    }

    public String dfs(String text, HashMap<String, String> hm) {
        if (!text.contains("%"))
            return text;
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') || text.charAt(i) == '_') {
                temp += text.charAt(i);
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                temp += hm.get("" + text.charAt(i));
            }
        }
        return dfs(temp, hm);
    }
}