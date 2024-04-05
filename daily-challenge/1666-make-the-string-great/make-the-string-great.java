class Solution {
    public String makeGood(String s) {
        char ch[] = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (!st.isEmpty() && Math.abs(st.peek() - ch[i]) == 32) {
                st.pop();
            } else
                st.push(ch[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append(st.pop());

        return sb.reverse().toString();
    }
}