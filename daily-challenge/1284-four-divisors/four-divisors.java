class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += getDivisorSum(nums[i]);
        }
        return sum;
    }

    public int getDivisorSum(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                    sum += i;
                } else {
                    count += 2;
                    sum += (n / i) + i;
                }
            }
        }
        return count == 4 ? sum : 0;
    }
}