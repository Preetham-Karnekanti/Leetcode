class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int pastWeek = 1;
        int start = pastWeek;
        for (int i = 1; i <= n; i++) {
            ans = ans + start;
            start++;
            if (i % 7 == 0) {
                pastWeek++;
                start = pastWeek;
            }
        }
        return ans;
    }
}