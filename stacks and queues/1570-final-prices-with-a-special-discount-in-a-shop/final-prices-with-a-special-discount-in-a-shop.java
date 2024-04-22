class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
                continue;
            }
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                ans[st.peek()] = prices[i];
                st.pop();
            }
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i] - ans[i];
        }
        return ans;
    }
}