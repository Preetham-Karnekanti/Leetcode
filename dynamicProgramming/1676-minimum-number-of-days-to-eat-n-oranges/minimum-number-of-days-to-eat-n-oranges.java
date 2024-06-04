class Solution {
    HashMap<Integer, Integer> dp;

    public int minDays(int n) {
        dp = new HashMap<>();
        return helper(n);
    }

    public int helper(int n) {
        if (n <= 2)
            return n;
        if (dp.get(n) != null)
            return dp.get(n);
        int val = 1 + Math.min(n % 2 + helper(n / 2), n % 3 + helper(n / 3));
        dp.put(n, val);
        return val;
    }
}