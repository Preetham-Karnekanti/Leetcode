class Solution {
    public int maxOperations(String s) {
        int i = 0, cnt = 0, ans = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                cnt++;
                i++;
            } else {
                while (i < s.length() && s.charAt(i) == '0') {
                    i++;
                }
                ans += cnt;
            }
        }

        return ans;
    }
}