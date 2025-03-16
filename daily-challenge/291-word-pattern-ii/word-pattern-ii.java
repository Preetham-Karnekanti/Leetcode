class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        return helper(pattern, s, new HashMap<>(), 0, 0, new HashSet<>());
    }

    public boolean helper(String p, String s, HashMap<Character, String> hm, int p1, int p2,
            HashSet<String> hs) {
        if (p1 == p.length() && p2 == s.length())
            return true;
        if (p1 == p.length() || p2 == s.length())
            return false;
        char ch = p.charAt(p1);
        if (hm.containsKey(ch)) {
            String word = hm.get(ch);
            if (!s.startsWith(word, p2))
                return false;
            return helper(p, s, hm, p1 + 1, p2 + word.length(), hs);
        }
        for (int i = p2; i < s.length(); i++) {
            String substr = s.substring(p2, i + 1);
            if (hs.contains(substr))
                continue;
            hm.put(ch, substr);
            hs.add(substr);
            if (helper(p, s, hm, p1 + 1, i + 1, hs))
                return true;
            hm.remove(ch);
            hs.remove(substr);
        }
        return false;
    }
}