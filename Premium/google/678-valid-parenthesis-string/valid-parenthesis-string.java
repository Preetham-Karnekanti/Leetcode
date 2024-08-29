class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openingStack = new Stack<>();
        Stack<Integer> astrekStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openingStack.push(i);
            } else if (s.charAt(i) == '*') {
                astrekStack.push(i);
            } else {
                if (!openingStack.isEmpty()) {
                    openingStack.pop();
                } else if (!astrekStack.isEmpty()) {
                    astrekStack.pop();
                } else
                    return false;
            }
        }

        while (!astrekStack.isEmpty() && !openingStack.isEmpty()) {
            if (openingStack.pop() > astrekStack.pop())
                return false;
        }
        return openingStack.isEmpty();
    }
}