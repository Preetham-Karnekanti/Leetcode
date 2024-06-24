class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                long sum = (long) target - (long) nums[i] - (long) nums[j];
                int l = j + 1;
                int m = nums.length - 1;
                while (l < m) {
                    long temp = nums[l] + nums[m];
                    if (temp == sum) {
                        List<Integer> al = new ArrayList<>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[l]);
                        al.add(nums[m]);
                        ans.add(al);
                        l++;
                        m--;
                        while (m > l && nums[m] == nums[m + 1])
                            m--;
                    } else if (temp > sum)
                        m--;
                    else
                        l++;
                }
            }
        }

        return ans;
    }
}