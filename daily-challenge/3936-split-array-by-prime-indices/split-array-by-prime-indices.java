class Solution {
    public long splitArray(int[] nums) {
        boolean[] primes = getPrimes(nums.length + 1);
        long primeSum = 0, nonPrimeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (primes[i]) {
                primeSum += nums[i];
            } else
                nonPrimeSum += nums[i];
        }
        return Math.abs(primeSum - nonPrimeSum);
    }

    public boolean[] getPrimes(int n) {
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
        return isPrime;
    }
}