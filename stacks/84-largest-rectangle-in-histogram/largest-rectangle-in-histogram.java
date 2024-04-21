class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {

            while (st.size() > 1 && heights[st.peek()] > heights[i]) {
                int cur = heights[st.pop()];
                int lb = st.peek();
                int rb = i;
                max = Math.max(max, (rb - lb - 1) * cur);
            }
            st.push(i);
        }

        while (st.size() > 1) {
            int cur = heights[st.pop()];
            int lb = st.peek();
            int rb = heights.length;
            max = Math.max(max, (rb - lb - 1) * cur);
        }

        return max;
    }
}