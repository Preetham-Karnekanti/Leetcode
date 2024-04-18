class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        HashSet<String> hs = new HashSet<>();
        hs.add("*");
        hs.add("+");
        hs.add("-");
        hs.add("/");
        for (int i = 0; i < tokens.length; i++) {
            if (hs.contains(tokens[i])) {
                Integer first = st.pop();
                Integer second = st.pop();
                Integer ans = evaluate(first, second, tokens[i]);
                st.push(ans);
            } else {
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.peek();
    }

    public Integer evaluate(Integer a, Integer b, String operand) {
        switch (operand) {
            case "*":
                return a * b;
            case "-":
                return b - a;
            case "/":
                return b / a;
            case "+":
                return a + b;
        }
        return 0;
    }
}