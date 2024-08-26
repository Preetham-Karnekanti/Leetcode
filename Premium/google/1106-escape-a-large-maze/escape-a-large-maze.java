class Pair {

    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        Set<String> set = new HashSet<>();

        for (int[] b : blocked)
            set.add(b[0] + " " + b[1]);

        return bfs(source, target, set) && bfs(target, source, set);

    }

    public boolean bfs(int[] source, int[] target, Set<String> set) {

        Set<String> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(source[0], source[1]));

        int arr1[] = { 0, 0, -1, 1 };
        int arr2[] = { 1, -1, 0, 0 };
        int count = 0;

        while (!q.isEmpty()) {

            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();

            count = count + 1;

            for (int i = 0; i < 4; i++) {
                int nr = r + arr1[i];
                int nc = c + arr2[i];

                String v = nr + " " + nc;
                if (nr >= 0 && nr < 1000000 && nc >= 0 && nc < 1000000 && !visited.contains(v)) {

                    if (nr == target[0] && nc == target[1])
                        return true;

                    if (set.contains(v))
                        continue;

                    visited.add(v);

                    q.offer(new Pair(nr, nc));

                    if (count > 19900)
                        return true;
                }
            }
        }

        return false;

    }
}