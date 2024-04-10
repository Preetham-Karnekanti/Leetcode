class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                st.push(i);
            } else if (cur == ')') {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(')
                    st.pop();
                else
                    st.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(!st.isEmpty() && st.peek() == i){
                st.pop();
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}