class Solution {
    public int maximumGain(String s, int x, int y) {
        int points = 0;
        Stack<Character> st = new Stack<>();
        if (x > y) {
            points += removeAB(s, x, st);
            s = buildString(st);
            points += removeBA(s, y, st);
        } else {
            points += removeBA(s, y, st);
            s = buildString(st);
            points += removeAB(s, x, st);
        }
        return points;
    }

    public int removeAB(String s, int value, Stack<Character> st) {
        int points = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b' && !st.isEmpty() && st.peek() == 'a') {
                st.pop();
                points += value;
            } else
                st.push(s.charAt(i));
        }
        return points;
    }

    public int removeBA(String s, int value, Stack<Character> st) {
        int points = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' && !st.isEmpty() && st.peek() == 'b') {
                st.pop();
                points += value;
            } else
                st.push(s.charAt(i));
        }
        return points;
    }

    public String buildString(Stack<Character> st) {
        StringBuilder s = new StringBuilder();
        while (!st.isEmpty()) {
            s.append(st.pop());
        }
        return s.reverse().toString();
    }
}