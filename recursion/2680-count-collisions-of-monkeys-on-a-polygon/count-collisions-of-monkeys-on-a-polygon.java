class Solution {
    int mod = 1000000007;
//total posibilities are  2^n - 2(all onkey moving eiher clocl or anti-clock wise)
    public int monkeyMove(int n) {
        int exp = (int) pow(2, n) % mod;
        return (int) (exp + mod - 2) % mod;
    }

    private long pow(long a, long b) {
        if (b == 0)
            return 1;
        long temp = pow(a, b / 2);
        long ans = temp * temp % mod;
        if (b % 2 == 1)
            ans = ans * a % mod;
        return ans;
    }
}