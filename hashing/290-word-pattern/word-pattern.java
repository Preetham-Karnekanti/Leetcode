class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        String ch[] = s.split(" ");
        if (pattern.length() != ch.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (hm.containsKey(pattern.charAt(i))) {
                if (!hm.get(pattern.charAt(i)).equals(ch[i]))
                    return false;
            } else {
                if (hs.contains(ch[i]))
                    return false;
                hm.put(pattern.charAt(i), ch[i]);
                hs.add(ch[i]);
            }
        }
        return true;
    }
}