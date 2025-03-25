class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, 0) || check(rectangles, 1);
    }

    public boolean check(int[][] rectangles, int dim) {
        Arrays.sort(rectangles, (a, b) -> a[dim] - b[dim]);
        int count = 0;
        int end = rectangles[0][dim + 2];
        for (int i = 1; i < rectangles.length; i++) {
            int rec[] = rectangles[i];
            if (end <= rec[dim]) {
                count++;
            }
            end = Math.max(end, rec[dim + 2]);
        }
        return count >= 2;
    }
}