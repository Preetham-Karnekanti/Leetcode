class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                st.pop();
            }
            st.push(i);
        }
        int ans[] = new int[st.size()];
        int idx = ans.length - 1;
        while (!st.isEmpty()) {
            ans[idx--] = st.pop();
        }
        return ans;
    }
}