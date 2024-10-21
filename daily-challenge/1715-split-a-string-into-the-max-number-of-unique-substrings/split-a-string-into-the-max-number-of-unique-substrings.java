class Solution {
    public int maxUniqueSplit(String s) {
        return helper(s, 0, new HashSet<>());
    }

    public int helper(String s, int idx, HashSet<String> hs) {
        if (idx == s.length())
            return 0;
        int max = 0;
        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);
            if (hs.contains(str))
                continue;
            hs.add(str);
            max = Math.max(max, 1 + helper(s, i + 1, hs));
            hs.remove(str);
        }
        return max;
    }
}