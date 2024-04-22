class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'c') {
                if (st.size() < 2)
                    return false;
                char ch = st.pop();
                if (ch != 'b')
                    return false;
                ch = st.pop();
                if (ch != 'a')
                    return false;

            }else
            st.push(s.charAt(i));
        }
        return st.isEmpty();
    }
}