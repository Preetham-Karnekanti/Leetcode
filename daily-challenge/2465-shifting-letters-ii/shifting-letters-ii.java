class Solution {
    int BACKWARD = 0;
    int FORWARD = 1;

    public String shiftingLetters(String s, int[][] shifts) {
        int forward[] = new int[s.length() + 1];
        int backward[] = new int[s.length() + 1];

        for (int p[] : shifts) {
            int l = p[0];
            int r = p[1] + 1;
            int direction = p[2];
            if (direction == BACKWARD) {
                backward[l] += 1;
                backward[r] -= 1;
            } else {
                forward[l] += 1;
                forward[r] -= 1;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            backward[i] += backward[i - 1];
            forward[i] += forward[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int netDiff = forward[i] - backward[i];
            if (netDiff == 0) {
                sb.append(s.charAt(i));
                continue;
            }
            int direction = netDiff < 0 ? BACKWARD : FORWARD;
            char ch = getChar(s.charAt(i), netDiff);
            sb.append(ch);
        }

        return sb.toString();
    }

    public char getChar(char ch, int steps) {
        steps = steps % 26;
        return (char) ('a' + (ch - 'a' + steps + 26) % 26);
    }
}