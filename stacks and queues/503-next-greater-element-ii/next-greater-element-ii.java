class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                ans[st.peek()] = nums[i % n];
                st.pop();
            }
            st.push(i % n);
        }
        return ans;
    }
}