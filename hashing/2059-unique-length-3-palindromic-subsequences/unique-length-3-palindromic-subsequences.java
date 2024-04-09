class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, int[]> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.get(s.charAt(i))[1] = i;
            } else
                hm.put(s.charAt(i), new int[] { i, i });
        }
        int ans = 0;
        for (int[] value : hm.values()) {
            int left = value[0];
            int right = value[1];
            HashSet<Character> hs = new HashSet<>();
            for (int i = left + 1; i < right; i++)
                hs.add(s.charAt(i));
            ans += hs.size();
        }
        return ans;
    }
}