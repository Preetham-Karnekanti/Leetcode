class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int count = 0;
        // constructing monotonic decreasing Stack of Given Array
        for (int i = 0; i < nums.length; i++) {
            if (s.isEmpty() || nums[s.peek()] > nums[i]) {
                s.push(i);
            }
        }
        // finding width of ramp
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                max = Math.max(i - s.pop(), max);
            }
        }
        return max;
    }
}