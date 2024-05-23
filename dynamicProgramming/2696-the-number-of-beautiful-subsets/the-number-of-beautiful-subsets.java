class Solution {
    int ans[];

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        ans = new int[1];
        helper(nums, k, 0, new ArrayList<>());
        return ans[0] - 1;
    }

    public void helper(int[] nums, int k, int idx, ArrayList<Integer> temp) {
        if (idx == nums.length) {
            ans[0]++;
            return;
        }
        if (temp.size() == 0 || !temp.contains(nums[idx] - k)) {
            temp.add(nums[idx]);
            helper(nums, k, idx + 1, temp);
            temp.remove(temp.size() - 1);
        }
        helper(nums, k, idx + 1, temp);
    }
}