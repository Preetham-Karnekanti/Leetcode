class Solution {
    public int maxScore(String s) {
        int max = Integer.MIN_VALUE;
        int ones = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0')
                zeros++;
            else
                ones++;
            max = Math.max(max, zeros - ones);
        }
        if (s.charAt(s.length() - 1) == '1')
            ones++;
        return max + ones;
    }
}