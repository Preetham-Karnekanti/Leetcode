class Solution {
    public int nthMagicalNumber(int n, int A, int B) {
        long a = A;
        long b = B;
        int m = (int) 1e9 + 7;
        long gcd = findGcd(a, b);
        long lcm = (a * b) / gcd;
        long low = Math.min(a, b);
        long high = n * Math.min(a, b);
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long value = (mid / a) + (mid / b) - (mid / lcm);
            if (value == mid) {
                return (int) (mid % m);
            }
            if (value < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return (int) (low % m);
    }

    public long findGcd(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        return findGcd(b, a % b);
    }
}