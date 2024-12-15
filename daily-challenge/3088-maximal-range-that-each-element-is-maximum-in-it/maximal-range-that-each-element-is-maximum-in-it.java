class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i])
                st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i])
                st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int[] ans = new int[n];
        for (int currIdx = 0; currIdx < n; currIdx++) {
            ans[currIdx] = right[currIdx] - left[currIdx] - 1;
        }

        return ans;

    }
}