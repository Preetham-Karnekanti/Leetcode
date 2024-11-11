class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] primes = getPrimes();
        int i = 0;
        int curValue = 1;
        while (i < nums.length) {
            int difference = nums[i] - curValue;
            if (difference < 0)
                return false;
            if (primes[difference] == true || difference == 0) {
                i++;
                curValue++;
            } else
                curValue++;
        }
        return true;
    }

    public boolean[] getPrimes() {
        boolean isPrime[] = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}