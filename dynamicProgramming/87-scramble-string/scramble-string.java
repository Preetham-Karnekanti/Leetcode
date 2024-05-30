class Solution {
    HashMap<String, Boolean> hm;

    public boolean isScramble(String s1, String s2) {
        hm = new HashMap<>();
        return helper(s1, s2);
    }

    public boolean helper(String s, String r) {
        if (s.equals(r))
            return true;
        String key = s + ":" + r;
        if (hm.containsKey(key))
            return hm.get(key);
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (helper(s.substring(0, i), r.substring(0, i))
                    && helper(s.substring(i), r.substring(i))) {
                hm.put(key, true);
                return true;
            }
            if (helper(s.substring(0, i), r.substring(n - i))
                    && helper(s.substring(i), r.substring(0, n - i))) {
                hm.put(key, true);
                return true;
            }
        }
        hm.put(key, false);
        return false;
    }
}