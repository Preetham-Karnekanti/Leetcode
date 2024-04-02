class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, 0, ans, new ArrayList<>());
        return ans;
    }

    public void solve(String s, int idx, List<List<String>> ans, List<String> temp) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPallindrome(s, idx, i)) {
                temp.add(s.substring(idx, i + 1));
                solve(s, i + 1, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPallindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}