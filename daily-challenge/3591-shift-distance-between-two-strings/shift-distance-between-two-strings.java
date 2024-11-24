class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long totalCost = 0;
        for (int i = 0; i < s.length(); ++i) {
            int start = s.charAt(i) - 'a';
            int target = t.charAt(i) - 'a';
            if (start == target)
                continue;

            int forwardSteps = (target - start + 26) % 26;
            long forwardCost = 0;
            for (int j = 0; j < forwardSteps; ++j) {
                forwardCost += nextCost[(start + j) % 26];
            }

            int backwardSteps = (start - target + 26) % 26;
            long backwardCost = 0;
            for (int j = 0; j < backwardSteps; ++j) {
                backwardCost += previousCost[(start - j + 26) % 26];
            }

            totalCost += Math.min(forwardCost, backwardCost);
        }
        return totalCost;
    }
}