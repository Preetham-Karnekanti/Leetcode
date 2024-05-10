class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i : forbidden) {
            hs.add(i);
        }
        hs.add(0);
        q.add(new Pair(0, ' '));
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.poll();
                if (p.pos == x)
                    return steps;
                int backward = p.pos - b;
                if (p.prev != 'b' && backward >= 0 && !hs.contains(backward)) {
                    hs.add(backward);
                    q.add(new Pair(backward, 'b'));
                }

                int forward = p.pos + a;
                if (!hs.contains(forward) && forward < 6000) {
                    hs.add(forward);
                    q.add(new Pair(forward, 'f'));
                }
            }
            steps++;
        }

        return -1;
    }
}

class Pair {
    int pos;
    char prev;

    Pair(int pos, char prev) {
        this.pos = pos;
        this.prev = prev;
    }
}