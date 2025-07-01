class Solution {
    public int possibleStringCount(String word) {
        int left = 0;
        int ans = 1;
        while (left < word.length()) {
            int right = left + 1;
            char ch = word.charAt(left);
            int count = 0;
            while (right < word.length() && ch == word.charAt(right)) {
                count++;
                right++;
            }
            ans += count;
            left = right;
        }
        return ans;
    }
}