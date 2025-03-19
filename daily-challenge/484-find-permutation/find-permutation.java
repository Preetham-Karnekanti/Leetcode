class Solution {
    public int[] findPermutation(String s) {
        int ans[] = new int[s.length() + 1];
        int j = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'I') {
                st.push(i);
                while (!st.isEmpty()) {
                    ans[j++] = st.pop();
                }
            } else
                st.push(i);
        }
        st.push(s.length() + 1);
        while (!st.isEmpty()) {
            ans[j++] = st.pop();
        }
        return ans;
    }
}