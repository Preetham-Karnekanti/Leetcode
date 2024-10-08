class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int m = monsters.length;
        Pair<Integer, Integer>[] monstersWithCoins = new Pair[m];
        for (int i = 0; i < m; i++) {
            monstersWithCoins[i] = new Pair<>(monsters[i], coins[i]);
        }
        Arrays.sort(monstersWithCoins, (a, b) -> {
            return a.getKey() - b.getKey();
        });

        int n = heroes.length;
        Pair<Integer, Integer> heroesWithIndex[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            heroesWithIndex[i] = new Pair<>(heroes[i], i);
        }

        Arrays.sort(heroesWithIndex, (a, b) -> {
            return a.getKey() - b.getKey();
        });
        int heroIdx = 0;
        int monsterIdx = 0;
        long score = 0;
        long ans[] = new long[n];
        while (heroIdx < n) {
            while (monsterIdx < m && monstersWithCoins[monsterIdx].getKey() <= heroesWithIndex[heroIdx].getKey()) {
                score += monstersWithCoins[monsterIdx++].getValue();
            }
            ans[heroesWithIndex[heroIdx].getValue()] = score;
            heroIdx++;
        }
        return ans;
    }
}
