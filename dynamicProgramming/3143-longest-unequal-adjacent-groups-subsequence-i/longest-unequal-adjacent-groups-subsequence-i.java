class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int prev = -1;
        for (int i = 0; i < words.length; i++) {
            if (groups[i] != prev) {
                ans.add(words[i]);
                prev = groups[i];
            }
        }
        return ans;
    }
}