class Solution {
    public long splitArray(int[] nums) {
        HashSet<Integer> primes = getPrimes(nums.length + 1);
        long primeSum = 0, nonPrimeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (primes.contains(i)) {
                primeSum += nums[i];
            } else
                nonPrimeSum += nums[i];
        }
        return Math.abs(primeSum - nonPrimeSum);
    }

    public HashSet<Integer> getPrimes(int n) {
        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i)
                    isPrime[j] = false;
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i])
                hs.add(i);
        }
        return hs;
    }
}