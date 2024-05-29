class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++)
            hm.put(c, c - 'a' + 1);
        for (int i = 0; i < chars.length(); i++)
            hm.put(chars.charAt(i), vals[i]);
        int max_so_far = 0;
        int max_ending_here = 0;
        for (int i = 0; i < s.length(); i++) {
            max_ending_here += hm.get(s.charAt(i));
            max_so_far = Math.max(max_so_far, max_ending_here);
            max_ending_here = Math.max(0, max_ending_here);
        }
        return max_so_far;
    }
}