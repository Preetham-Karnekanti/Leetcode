class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (y >= x)
            return y - x;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(x);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == y)
                    return steps;
                if (cur % 11 == 0 && !visited.contains(cur / 11)) {
                    q.add(cur / 11);
                    visited.add(cur / 11);
                }
                if (cur % 5 == 0 && !visited.contains(cur / 5)) {
                    q.add(cur / 5);
                    visited.add(cur / 5);
                }
                if (!visited.contains(cur + 1)) {
                    q.add(cur + 1);
                    visited.add(cur + 1);
                }
                if (cur > 0 && !visited.contains(cur - 1)) {
                    q.add(cur - 1);
                    visited.add(cur - 1);
                }
            }
            steps++;
        }
        return steps;
    }
}