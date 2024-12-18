class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int answer[] = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                answer[st.peek()] = prices[st.peek()] - prices[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            answer[st.peek()] = prices[st.pop()];
        }
        return answer;
    }
}