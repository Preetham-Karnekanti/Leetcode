class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int min[] = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(nums[i - 1], min[i - 1]);
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int one = min[i];
            int three = nums[i];
            if (one < three) {
                Integer two = ts.floor(three - 1);
                if (two != null && one < two)
                    return true;
            }
            ts.add(nums[i]);
        }
        return false;
    }
}