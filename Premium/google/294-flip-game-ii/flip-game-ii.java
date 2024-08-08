class Solution {
    public boolean canWin(String currentState) {
        HashMap<String, Boolean> hm = new HashMap<>();
        return helper(currentState, hm);
    }

    public boolean helper(String s, HashMap<String, Boolean> hm) {
        if (s == null || s.length() < 2)
            return false;
        if (hm.containsKey(s))
            return hm.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(t, hm)) {
                    hm.put(s, true);
                    return true;
                }
            }
        }
        hm.put(s, false);
        return false;
    }
}