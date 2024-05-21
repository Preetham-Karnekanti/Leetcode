class Solution {
    List<List<Integer>> al;

    public List<List<Integer>> subsets(int[] nums) {
        al = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>());
        return al;
    }

    public void subsets(int nums[], int idx, ArrayList<Integer> temp) {
        if (idx >= nums.length) {
            al.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        subsets(nums, idx + 1, temp);
        temp.remove(temp.size() - 1);
        subsets(nums, idx + 1, temp);
    }
}