class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }
        while (q.size() > 1) {
            for (int i = 1; i < k; i++)
                q.add(q.remove());
            q.poll();
        }
        return q.peek();
    }
}