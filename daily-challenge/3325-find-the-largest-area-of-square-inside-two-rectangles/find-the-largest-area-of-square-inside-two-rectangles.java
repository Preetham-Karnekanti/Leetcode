class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            Rectangle r1 = new Rectangle(bottomLeft[i], topRight[i]);
            for (int j = i + 1; j < n; j++) {
                Rectangle r2 = new Rectangle(bottomLeft[j], topRight[j]);
                max = Math.max(max, computeArea(r1, r2));
            }
        }
        return max;
    }

    public long computeArea(Rectangle r1, Rectangle r2) {
        int point1x = Math.max(r1.x1, r2.x1);
        int point1y = Math.max(r1.y1, r2.y1);
        int point2x = Math.min(r1.x2, r2.x2);
        int point2y = Math.min(r1.y2, r2.y2);
        int iL = point2x - point1x;
        int iB = point2y - point1y;
        if (iL <= 0 || iB <= 0)
            return 0;
        long min = Math.min(iL, iB);
        return min * min;
    }
}

class Rectangle {
    int x1, y1, x2, y2;

    Rectangle(int a[], int b[]) {
        x1 = a[0];
        x2 = b[0];
        y1 = a[1];
        y2 = b[1];
    }
}