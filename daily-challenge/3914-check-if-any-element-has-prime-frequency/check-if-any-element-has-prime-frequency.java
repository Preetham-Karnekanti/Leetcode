class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int count[] = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i : count) {
            if (isPrime(i))
                return true;
        }
        return false;
    }

    public boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}