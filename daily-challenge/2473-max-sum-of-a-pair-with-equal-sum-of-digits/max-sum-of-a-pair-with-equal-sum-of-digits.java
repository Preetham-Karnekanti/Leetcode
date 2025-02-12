class Solution {
    public int maximumSum(int[] nums) {
        int maxSum = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int digitSum = sumOfDigits(nums[i]);
            if (hm.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, nums[i] + hm.get(digitSum));
            }

            hm.put(digitSum, Math.max(hm.getOrDefault(digitSum, 0), nums[i]));
        }
        return maxSum;
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }
}