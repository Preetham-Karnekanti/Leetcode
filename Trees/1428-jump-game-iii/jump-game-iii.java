class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[arr.length];
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (arr[cur] == 0)
                return true;
            int prev = cur - arr[cur];
            int next = cur + arr[cur];
            if (isValid(prev, n) && !visited[prev]) {
                q.add(prev);
                visited[prev] = true;
            }
            if (isValid(next, n) && !visited[next]) {
                q.add(next);
                visited[next] = true;
            }
        }

        return false;
    }

    public boolean isValid(int idx, int n) {
        if (idx < 0 || idx >= n)
            return false;
        return true;
    }
}