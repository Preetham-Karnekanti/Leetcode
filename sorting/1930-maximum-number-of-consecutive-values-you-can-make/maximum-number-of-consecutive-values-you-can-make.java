class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int maxV = 1;
        for (int coin : coins) {
            if (maxV >= coin)
                maxV += coin;
            else break;
        }
        return maxV;
    }
}