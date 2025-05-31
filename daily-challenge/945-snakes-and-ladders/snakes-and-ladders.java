class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int dist[] = new int[n * n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= 6 && cur + i <= n * n; i++) {
                int next = cur + i;
                int nr = (next - 1) / n;
                int nc = (next - 1) % n;
                int value = board[n - 1 - nr][nr % 2 == 1 ? n - 1 - nc : nc];
                int cell =  value > 0 ? value : next;
                if(cell == n * n)
                    return dist[cur] + 1;
                if(dist[cell] > 1 + dist[cur]){
                    dist[cell] = 1 + dist[cur];
                    q.add(cell);
                }
            }
        }
        return -1;
    }
}