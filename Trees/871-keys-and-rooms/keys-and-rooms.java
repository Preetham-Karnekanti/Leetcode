class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        visited.add(0);
        q.add(new Pair(0));
        q.peek().existingKeys.add(0);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int key : rooms.get(p.room)) {
                if (!visited.contains(key)) {
                    Pair newKey = new Pair(key);
                    newKey.existingKeys.addAll(p.existingKeys);
                    newKey.existingKeys.add(key);
                    q.add(newKey);
                    visited.add(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}

class Pair {
    int room;
    HashSet<Integer> existingKeys;

    Pair(int room) {
        this.room = room;
        existingKeys = new HashSet<>();
    }
}