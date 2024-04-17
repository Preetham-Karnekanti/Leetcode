class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int len = 0;
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        char ch[] = s.toCharArray();
        while (right < n) {
            while (left <= right && hs.contains(ch[right])) {
                hs.remove(ch[left++]);
            }
            hs.add(ch[right]);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}