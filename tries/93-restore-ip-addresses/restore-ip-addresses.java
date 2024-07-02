class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(s, 1, 0, ans);
        return ans;
    }

    public void solve(String s, int idx, int dots, List<String> ans) {
        if (dots == 3) {
            if (isValid(s))
                ans.add(s);
            return;
        }
        if (idx >= s.length())
            return;
        solve(s.substring(0, idx) + "." + s.substring(idx, s.length()), idx + 2, dots + 1, ans);
        solve(s, idx + 1, dots, ans);
    }

    public boolean isValid(String s) {
        // System.out.println(s);
        String[] addresses = s.split("\\.");
        for (int i = 0; i < addresses.length; i++) {
            if (hasLeadingZeros(addresses[i]))
                return false;
            if (addresses[i].length() > 3)
                return false;
            int num = Integer.parseInt(addresses[i]);
            if (num > 255)
                return false;
        }
        return true;
    }

    public boolean hasLeadingZeros(String s) {
        return s.length() > 1 && s.charAt(0) == '0';
    }
}