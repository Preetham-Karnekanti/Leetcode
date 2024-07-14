class Solution {
    int n, goal, k;
    long[][] memo;
    int MOD = 1_000_000_000 + 7;

    public int numMusicPlaylists(int n, int goal, int k) {
        this.n = n;
        this.goal = goal;
        this.k = k;
        memo = new long[goal + 1][n + 1];
        for (int i = 0; i < goal + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (int) recurse(goal, 0);
    }

    long recurse(int curGoal, int oldSongs) {
        if (curGoal == 0 && oldSongs == n) {
            return 1;
        }
        if (curGoal == 0 || oldSongs > n) {
            return 0;
        }
        if (memo[curGoal][oldSongs] != -1) {
            return memo[curGoal][oldSongs];
        }
        // Choose from new songs. We have (n - oldSongs) options to choose from
        // We will increase our oldSongs count. As it tracks the count of unique songs.
        // As we chose a new song, we increment the unique songs aka oldSongs count
        long newSong = (n - oldSongs) * recurse(curGoal - 1, oldSongs + 1);
        long onRepeat = 0;
        if (oldSongs > k) {
            // Choose from old songs. We have (oldSongs - k) options to choose from
            // oldSongs is the count of unique songs. So, we won't be incrementing it.
            // As we are choosing from the old songs.
            onRepeat = (oldSongs - k) * recurse(curGoal - 1, oldSongs);
        }
        return memo[curGoal][oldSongs] = ((newSong) % MOD + (onRepeat) % MOD) % MOD;
    }
}