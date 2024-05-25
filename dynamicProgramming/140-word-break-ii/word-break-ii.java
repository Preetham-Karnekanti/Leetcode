class Solution {
    ArrayList<String> ans;

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>(wordDict);
        helper(s, new ArrayList<>(), 0, hs);
        return ans;
    }

    public void helper(String s, ArrayList<String> temp, int idx, HashSet<String> hs) {
        if (idx >= s.length()) {
            String str = "";
            for (int i = 0; i < temp.size(); i++)
                str = str + " " + temp.get(i);
            ans.add(str.strip());
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String t = s.substring(idx, i + 1);
            if (hs.contains(t)) {
                temp.add(t);
                helper(s, temp, i + 1, hs);
                temp.remove(temp.size() - 1);
            }
        }
    }
}