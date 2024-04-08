class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            hs.add(nums[i]);
        while (hs.contains(original))
            original *= 2;
        return original;
    }
}