class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });
        HashSet<String> hs = new HashSet<>();
        hs.add(0 + ":" + 1);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int moves = cur[0];
            int position = cur[1];
            int speed = cur[2];
            if (position == target)
                return moves;
            int nextPosition = speed + position;
            int nextSpeed = speed * 2;
            if (nextPosition >= 0 && nextPosition < target * 2 && !hs.contains(nextPosition + ":" + nextSpeed)) {
                hs.add(nextPosition + ":" + nextSpeed);
                q.add(new int[] { moves + 1, nextPosition, nextSpeed });
            }
            nextSpeed = speed > 0 ? -1 : 1;
            if (position >= 0 && position < target * 2 && !hs.contains(position + ":" + nextSpeed)) {
                hs.add(position + ":" + nextSpeed);
                q.add(new int[] { moves + 1, position, nextSpeed });
            }
        }
        return 0;
    }
}