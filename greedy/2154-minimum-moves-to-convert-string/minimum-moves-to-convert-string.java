class Solution {
    public int minimumMoves(String s) {
        int steps = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == 'X') {
                i += 3;
                steps++;
            } else
                i++;
        }
        return steps;
    }
}