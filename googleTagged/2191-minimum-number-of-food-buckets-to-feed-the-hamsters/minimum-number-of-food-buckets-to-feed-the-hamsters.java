class Solution {
    public int minimumBuckets(String hamsters) {
        if (hamsters.equals("H"))
            return -1;
        if (hamsters.equals("."))
            return 0;
        int n = hamsters.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if (i < n - 1 && hamsters.charAt(i + 1) == '.') {
                    ans++;
                    i += 2;
                } else if (i > 0 && hamsters.charAt(i - 1) == '.') {
                    ans++;
                } else
                    return -1;
            }
        }
        return ans;
    }
}