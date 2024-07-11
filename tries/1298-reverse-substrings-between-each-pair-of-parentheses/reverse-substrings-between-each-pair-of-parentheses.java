class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) != ')')
                st.push(s.charAt(i));
            else if (s.charAt(i) == ')') {
                String temp = "";
                while (!st.isEmpty() && st.peek() != '(') {
                    temp += st.pop();
                }
                st.pop();
                for (int j = 0; j < temp.length(); j++)
                    st.push(temp.charAt(j));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}