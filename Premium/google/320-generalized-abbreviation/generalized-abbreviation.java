class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        helper(word, ans, 0, 0, "");
        return ans;
    }

    public void helper(String word, List<String> ans, int count, int idx, String cur) {
        if (idx == word.length()) {
            if (count > 0)
                cur += count;
            ans.add(cur);
        } else {
            helper(word, ans, count + 1, idx + 1, cur);
            helper(word, ans, 0, idx + 1, cur + (count > 0 ? count : "") + word.charAt(idx));
        }
    }
}