class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(ans - target) > Math.abs(sum - target))
                    ans = sum;
                if (sum > target)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }
}