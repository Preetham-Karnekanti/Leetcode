class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for (String cur : operations) {
            if (cur.equals("C")) {
                st.pop();
            } else if (cur.equals("D")) {
                st.push(st.peek() * 2);
            } else if (cur.equals("+")) {
                int val1 = st.pop();
                int val2 = st.peek();
                st.push(val1);
                st.push(val1 + val2);
            } else {
                int val = Integer.valueOf(cur);
                st.push(val);
            }
        }
        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}