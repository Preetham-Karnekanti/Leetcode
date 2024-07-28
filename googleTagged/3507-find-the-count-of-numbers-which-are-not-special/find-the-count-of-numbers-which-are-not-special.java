class Solution {
    public int nonSpecialCount(int l, int r) {
        int limit = (int) Math.sqrt(r);
        boolean primes[] = new boolean[limit + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i <= limit; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= limit; j += i)
                    primes[j] = false;
            }
        }

        int specialCount = 0;
        for (int i = 0; i <= limit; i++) {
            if (primes[i]) {
                int square = i * i;
                if (l <= square && square <= r) {
                    specialCount++;
                }
            }
        }
        return r - l + 1 - specialCount;
    }
}