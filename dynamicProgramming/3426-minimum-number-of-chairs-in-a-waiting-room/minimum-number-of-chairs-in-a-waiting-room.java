class Solution {
    public int minimumChairs(String s) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E')
                ans++;
            else
                ans--;
            max = Math.max(max, ans);
        }
        return max;
    }
}