class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        ArrayList<HashMap<Integer, Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new HashMap<>());
        }
        HashSet<Integer> playerCount = new HashSet<>();
        for (int p[] : pick) {
            int player = p[0];
            int color = p[1];
            HashMap<Integer, Integer> eachPlayer = al.get(player);
            eachPlayer.put(color, eachPlayer.getOrDefault(color, 0) + 1);
            if (eachPlayer.get(color) > player) {
                playerCount.add(player);
            }
        }
        return playerCount.size();
    }
}