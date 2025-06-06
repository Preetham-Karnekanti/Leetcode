class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (st.isEmpty() == false)
                    st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}