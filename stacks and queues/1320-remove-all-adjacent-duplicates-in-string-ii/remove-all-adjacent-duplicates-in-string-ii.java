class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(new Pair(s.charAt(i)));
                continue;
            }
            if (st.peek().ch == s.charAt(i)) {
                st.peek().count++;
                if (st.peek().count == k)
                    st.pop();
            } else
                st.push(new Pair(s.charAt(i)));
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            int count = st.peek().count;
            char ch = st.peek().ch;
            for (int i = 0; i < count; i++)
                sb.append(ch);
            st.pop();
        }
        return sb.reverse().toString();
    }
}

class Pair {
    char ch;
    int count;

    Pair(char ch) {
        this.ch = ch;
        this.count = 1;
    }
}