class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        String[] map = new String[26];

        for (int i = 0; i < replacements.size(); i++) {
            map[replacements.get(i).getFirst().charAt(0) - 'A'] = replacements.get(i).getLast();
        }

        return helper(map, text);
    }

    static String helper(String[] map, String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '%') {
                char token = text.charAt(i + 1);
                String mapped = map[token - 'A'];
                while (mapped.contains("%")) {
                    mapped = helper(map, mapped);
                }
                map[token - 'A'] = mapped;
                sb.append(mapped);
                i += 2;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}