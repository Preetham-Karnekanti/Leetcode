class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        int n = enemyEnergies.length;
        long coins = 0;
        int i = 0;
        int j = n - 1;
        while (j >= 0) {
            if (currentEnergy >= enemyEnergies[i]) {
                coins += currentEnergy / enemyEnergies[i];
                currentEnergy %= enemyEnergies[i];
            } else if (coins >= 1) {
                currentEnergy += enemyEnergies[j];
                j--;
            } else {
                break;
            }
        }
        return coins;
    }
}