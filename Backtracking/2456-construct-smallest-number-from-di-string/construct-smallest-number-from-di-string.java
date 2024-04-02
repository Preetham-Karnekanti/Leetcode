class Solution {
    String ans = "";

    public String smallestNumber(String pattern) {
        solve(pattern, "", new boolean[10]);
        return ans;
    }

    public void solve(String pattern, String current, boolean[] used) {
        // if (ans.length() > 0)
        // return;
        if (current.length() == pattern.length() + 1) {
            if (isValid(current, pattern)) {
                if (ans.length() == 0) {
                    ans = current;
                } else if (ans.compareTo(current) > 0)
                    ans = current;
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                solve(pattern, current + i, used);
                used[i] = false;
            }
        }
    }

    public boolean isValid(String num, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I' && num.charAt(i) > num.charAt(i + 1))
                return false;
            if (pattern.charAt(i) == 'D' && num.charAt(i) < num.charAt(i + 1))
                return false;
        }
        return true;
    }
}