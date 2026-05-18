class Solution {
    public int minJumps(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        HashMap<Integer, Queue<Integer>> hm = new HashMap<>();
        boolean visited[] = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            hm.putIfAbsent(arr[i], new LinkedList<>());
            hm.get(arr[i]).add(i);
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == arr.length - 1)
                    return steps;
                if (cur + 1 < arr.length && !visited[cur + 1]) {
                    visited[cur + 1] = true;
                    q.add(cur + 1);
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    visited[cur - 1] = true;
                    q.add(cur - 1);
                }
                Queue<Integer> indices = hm.get(arr[cur]);
                while (indices.size() > 0) {
                    int ele = indices.poll();
                    if (!visited[ele]) {
                        q.add(ele);
                        visited[ele] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}