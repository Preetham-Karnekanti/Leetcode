class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (solve(String.valueOf(i * i), 0, 0, i)) {
                sum += i * i;
            }
        }
        return sum;
    }

    public boolean solve(String num, int sum, int idx, int n) {
        if (idx == num.length())
            return sum == n;
        for (int i = idx; i < num.length(); i++) {
            if (solve(num, sum + Integer.parseInt(num.substring(idx, i + 1)), i + 1, n))
                return true;
        }
        return false;
    }
}