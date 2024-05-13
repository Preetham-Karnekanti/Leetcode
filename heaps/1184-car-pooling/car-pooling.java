class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        ArrayList<Pair> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new Pair(trips[i][1], trips[i][0]));
            al.add(new Pair(trips[i][2], -trips[i][0]));
        }
        Collections.sort(al, (a, b) -> {
            if (a.time == b.time)
                return a.capacity - b.capacity;
            return a.time - b.time;
        });
        int cur = 0;
        for (Pair p : al) {
            cur = cur + p.capacity;
            if (cur > capacity)
                return false;
        }
        return true;
    }
}

class Pair {
    int time;
    int capacity;

    Pair(int time, int capacity) {
        this.time = time;
        this.capacity = capacity;
    }
}