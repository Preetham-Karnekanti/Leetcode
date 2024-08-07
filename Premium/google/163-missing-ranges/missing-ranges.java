class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> al = new ArrayList<>();
        if (nums.length == 0) {
            al.add(new ArrayList<>(Arrays.asList(lower, upper)));
            return al;
        }
        int i = 0;
        if (lower < nums[0]) {
            List<Integer> temp = new ArrayList<>(Arrays.asList(lower, nums[0] - 1));
            al.add(temp);
        }
        while (i < nums.length) {
            int j = i;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1])
                i++;
            if (i < nums.length - 1) {
                List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
                al.add(temp);
            } else if (i == nums.length - 1 && nums[i] != upper) {
                List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i] + 1, upper));
                al.add(temp);
            }
            i++;
        }
        return al;
    }
}