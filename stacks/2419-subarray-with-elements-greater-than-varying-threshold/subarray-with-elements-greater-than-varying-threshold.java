class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < nums.length; i++) {
            while (st.size() > 1 && nums[st.peek()] > nums[i]) {
                int cur = nums[st.pop()];
                int lb = st.peek();
                int rb = i;
                int len = rb - lb - 1;
                if (threshold / (double) len < cur)
                    return len;
            }
            st.push(i);
        }
        while (st.size() > 1) {
            int cur = nums[st.pop()];
            int lb = st.peek();
            int rb = nums.length;
            int len = rb - lb - 1;
            if (threshold / (double) len < cur)
                return len;
        }
        return -1;
    }
}