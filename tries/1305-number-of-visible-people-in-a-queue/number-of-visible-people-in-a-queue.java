class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            int h = heights[i];
            int count = 0;
            while (!st.isEmpty() && st.peek() < h) {
                st.pop();
                count++;
            }
            res[i] = count + (st.size() > 0 ? 1 : 0);
            st.push(h);
        }
        return res;
    }
}