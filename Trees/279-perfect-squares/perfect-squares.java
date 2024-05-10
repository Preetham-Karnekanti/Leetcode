class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        q.add(n);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == 0) {
                    return steps;
                }
                for (int i = 1; i * i <= cur; i++) {
                    int next = cur - i * i;
                    if (!hs.contains(next)) {
                        q.add(next);
                        hs.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}