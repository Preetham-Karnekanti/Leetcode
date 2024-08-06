class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = findArea(ax1, ay1, ax2, ay2);
        int area2 = findArea(bx1, by1, bx2, by2);
        int p1x = Math.max(ax1, bx1);
        int p1y = Math.max(ay1, by1);
        int p2x = Math.min(ax2, bx2);
        int p2y = Math.min(ay2, by2);
        int iL = p2x - p1x;
        int iB = p2y - p1y;
        int iarea = iL * iB;
        return area1 + area2 - (iarea > 0 && iL > 0 && iB > 0 ? iarea : 0);
    }

    public int findArea(int ax1, int ay1, int ax2, int ay2) {
        return Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
    }
}