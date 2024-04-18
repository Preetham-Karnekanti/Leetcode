class Solution {
    public int[] dailyTemperatures(int[] input) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[input.length];

        for (int i = 0; i < input.length; i++) {

            while (!st.isEmpty() && input[st.peek()] < input[i]) {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        return ans;
    }
}