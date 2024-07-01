class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red, blue, 1, 0), helper(red, blue, 1, 1));
    }

    public int helper(int red, int blue, int row, int curColor) {
        if (curColor == 0) {
            if (row > red)
                return 0;
        }
        if (curColor == 1) {
            if (row > blue)
                return 0;
        }
        int one = 0;
        int two = 0;
        if (curColor == 0) {
            if (row <= red)
                one = 1 + helper(red - row, blue, row + 1, 1);
        } else {
            if (row <= blue) {
                two = 1 + helper(red, blue - row, row + 1, 0);
            }
        }
        return Math.max(one, two);
    }
}