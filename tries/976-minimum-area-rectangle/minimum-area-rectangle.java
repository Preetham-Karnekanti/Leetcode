class Solution {
    public int minAreaRect(int[][] points) {
        HashSet<String> hs = new HashSet<>();
        for (int p[] : points) {
            String str = p[0] + ":" + p[1];
            hs.add(str);
        }
        int n = points.length;
        int area = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 != x2 && y1 != y2) {
                    String s1 = x1 + ":" + y2;
                    String s2 = x2 + ":" + y1;
                    if (area > Math.abs((x1 - x2) * (y1 - y2)))
                        if (hs.contains(s1) && hs.contains(s2)) {
                            area = Math.min(area, Math.abs((x1 - x2) * (y1 - y2)));
                        }
                }
            }
        }
        return area == Integer.MAX_VALUE ? 0 : area;
    }
}