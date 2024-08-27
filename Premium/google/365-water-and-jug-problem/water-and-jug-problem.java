class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        HashSet<String> hs = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int jug1 = cur[0];
            int jug2 = cur[1];
            if (jug1 + jug2 == target)
                return true;
            String key = jug1 + ":" + jug2;
            if (hs.contains(key))
                continue;
            hs.add(key);
            q.add(new int[] { 0, jug2 });
            q.add(new int[] { jug1, 0 });
            q.add(new int[] { x, jug2 });
            q.add(new int[] { jug1, y });
            q.add(new int[] {
                    jug1 - Math.min(jug1, y - jug2),
                    jug2 + Math.min(jug1, y - jug2) });
            q.add(new int[] {
                    jug1 + Math.min(x - jug1, jug2),
                    jug2 - Math.min(x - jug1, jug2)
            });
        }
        return false;
    }
}