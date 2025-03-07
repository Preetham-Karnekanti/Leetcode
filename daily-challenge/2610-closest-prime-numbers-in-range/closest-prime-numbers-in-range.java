class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean isPrime[] = seives(right + 1);
        ArrayList<Integer> primes = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPrime[i])
                primes.add(i);
        }
        int diff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;
        for (int i = 1; i < primes.size(); i++) {
            int cur = primes.get(i) - primes.get(i - 1);
            if (cur < diff) {
                diff = cur;
                num1 = primes.get(i - 1);
                num2 = primes.get(i);
            }
        }
        return new int[] { num1, num2 };
    }

    private boolean[] seives(int n) {
        boolean primes[] = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int p = 2 * i; p < n; p += i) {
                    primes[p] = false;
                }
            }
        }
        return primes;
    }
}