class DetectSquares {
    List<int[]> points;
    HashMap<String, Integer> hm;

    public DetectSquares() {
        points = new ArrayList<>();
        hm = new HashMap<>();
    }

    public void add(int[] point) {
        points.add(point);
        String key = point[0] + ":" + point[1];
        hm.put(key, hm.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int sum = 0;
        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
            if (px == x || py == y || Math.abs(px - x) != Math.abs(py - y))
                continue;
            String p1 = x + ":" + py;
            String p2 = px + ":" + y;
            sum += hm.getOrDefault(p1, 0) * hm.getOrDefault(p2, 0);
        }
        return sum;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */