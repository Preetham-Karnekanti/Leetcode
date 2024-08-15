class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int ones = 0;
        for (int i = 0; i < nums.length; i++)
            ones += nums[i];
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        int max = ones;
        int zeros = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 0)
                zeros++;
            else
                ones--;
            int sum = ones + zeros;
            if (sum > max) {
                ans.clear();
                ans.add(i);
                max = sum;
            } else if (sum == max) {
                ans.add(i);
            }
        }
        return ans;
    }
}

