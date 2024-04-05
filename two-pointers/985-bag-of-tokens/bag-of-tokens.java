class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0)
            return 0;
        Arrays.sort(tokens);
        int i = 0;
        int score = 0;
        int max = 0;
        int j = tokens.length - 1;
        if (tokens[i] > power)
            return 0;
        while (i <= j) {
            if (tokens[i] <= power) {
                power = power - tokens[i];
                score++;
                if (score > max)
                    max = score;
                i++;
            } else if (score >= 1) {
                power += tokens[j--];
                score--;
            } else {
                break;
            }
        }
        return max;
    }
}