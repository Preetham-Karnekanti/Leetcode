class Solution {
    public int minimizeSet(int d1, int d2, int cnt1, int cnt2) {
        long low = 1;
        long high = (long) Math.pow(10, 10);
        long ans = 0;
        while (low <= high) {
            long mid = (high + low) / 2;
            long notFactorsOfD1 = mid - mid / d1;
            long notFactorsOfD2 = mid - mid / d2;
            long notFactorOFD1D2 = mid - mid / lcm(d1, d2);
            if (notFactorsOfD1 >= cnt1 && notFactorsOfD2 >= cnt2 && notFactorOFD1D2 >= (cnt1 + cnt2)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    public long lcm(long a, long b) {
        long g = gcd(a, b);
        return a * b / g;
    }

    public long gcd(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}