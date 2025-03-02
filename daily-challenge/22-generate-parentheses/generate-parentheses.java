class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(ans, new char[2 * n], 0, 0, n, 0);
        return ans;
    }

    public void solve(List<String> ans, char ch[], int open, int close, int n, int idx) {
        if (idx == ch.length) {
            ans.add(new String(ch));
            return;
        }
        if (open < n) {
            ch[idx] = '(';
            solve(ans, ch, open + 1, close, n, idx + 1);
            ch[idx] = '-';
        }
        if (close < open) {
            ch[idx] = ')';
            solve(ans, ch, open, close + 1, n, idx + 1);
            ch[idx] = '-';
        }
    }
}