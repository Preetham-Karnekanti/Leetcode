class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> hs = new HashSet<>();
        solve(tiles, hs, "", new boolean[tiles.length()]);
        return hs.size() - 1;
    }

    private void solve(String tiles, HashSet<String> hs, String temp, boolean[] vis) {
        hs.add(temp);
        for (int i = 0; i < tiles.length(); i++) {
            if (vis[i])
                continue;
            vis[i] = true;
            solve(tiles, hs, temp + tiles.charAt(i), vis);
            vis[i] = false;
        }

    }
}