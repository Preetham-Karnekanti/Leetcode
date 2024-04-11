class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        for (i = 0; i < num.length(); i++) {
            while (k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while (k-- > 0 && !st.isEmpty()) {
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append(st.pop());
        if (sb.length() == 0)
            return "0";
        i = 0;
        sb.reverse();
        while (i < sb.length() && sb.charAt(i) == '0')
            i++;
        if(i == sb.length())
            return "0";
        return sb.substring(i).toString();
    }

}