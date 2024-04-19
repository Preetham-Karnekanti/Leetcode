class Solution {
    public int scoreOfParentheses(final String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int tmp = stack.pop();
                int val = 0;
                if (tmp > 0)
                    val = tmp * 2;
                else
                    val = 1;
                stack.push(stack.pop() + val);
            }
        }
        return stack.peek();
    }
}