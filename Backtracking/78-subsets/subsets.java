class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        backtrack(answers, new ArrayList<>(), nums, 0);

        return answers;
    }

    void backtrack(List<List<Integer>> answers, List<Integer> subset, int[] nums, int index) {
        if (index == nums.length) {
            answers.add(new ArrayList<>(subset));
            return;
        }
        backtrack(answers, subset, nums, index + 1);
        subset.add(nums[index]);
        backtrack(answers, subset, nums, index + 1);
        subset.remove(subset.size() - 1);
    }
}