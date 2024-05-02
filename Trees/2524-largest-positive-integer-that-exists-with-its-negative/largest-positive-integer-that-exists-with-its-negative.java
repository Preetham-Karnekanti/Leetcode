class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            hm.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && hm.contains(-nums[i]))
                max = Math.max(max, nums[i]);
        }
        return max;
    }
}