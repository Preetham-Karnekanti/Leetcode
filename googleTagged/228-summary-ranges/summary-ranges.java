class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length - 1 && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            String value;
            if (i != j)
                value = nums[i] + "->" + nums[j];
            else
                value = nums[i] + "";
            ans.add(value);
            i = j;
        }
        return ans;
    }
}