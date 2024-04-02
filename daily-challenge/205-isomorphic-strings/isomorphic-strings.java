class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                if (hm.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if (hs.contains(t.charAt(i)))
                    return false;
                hm.put(s.charAt(i), t.charAt(i));
                hs.add(t.charAt(i));
            }
        }
        return true;
    }
}