class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int maxV = 1;
        for (int coin : coins) {
            if (coin <= maxV)
                maxV += coin;
        }
        return maxV;
    }
}