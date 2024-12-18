public class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                // If already more than one violation, return false
                if (++count > 1) {
                    return false;
                }
                
                // Check if removing nums[i-1] or nums[i] resolves the issue
                if (i - 2 >= 0 && nums[i - 2] >= nums[i]) {
                    // Removing nums[i-1] won't work, so try removing nums[i]
                    if (i + 1 < n && nums[i - 1] >= nums[i + 1]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
