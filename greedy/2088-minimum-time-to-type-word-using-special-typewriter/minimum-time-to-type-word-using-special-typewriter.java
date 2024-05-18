class Solution {
    public int minTimeToType(String word) {
        int ans = word.length();
        int diff = Math.abs((int) (word.charAt(0) - 'a'));
        ans += Math.min(diff, 26 - diff);
        for (int i = 1; i < word.length(); i++) {
            diff = Math.abs((int) (word.charAt(i) - word.charAt(i - 1)));
            ans += Math.min(diff, 26- diff);
        }
        return ans;
    }
}