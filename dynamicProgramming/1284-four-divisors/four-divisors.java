class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int sum = 0;
            for (int j = 1; j * j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    if (nums[i] / j == j) {
                        count++;
                        sum += j;
                    } else {
                        count += 2;
                        sum += j + (nums[i] / j);
                    }
                }
            }
            if (count == 4)
                ans += sum;
        }
        return ans;
    }
}