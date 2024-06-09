class Solution {
    public int numberOfChild(int n, int k) {
        int ballPosition = 0;
        int direction = 1;
        for (int i = 0; i < k; i++) {
            if (direction == 1) {
                if (ballPosition == n - 1)
                    direction = -1;
                ballPosition += direction;
            } else {
                if (ballPosition == 0)
                    direction = 1;
                ballPosition += direction;
            }
        }
        return ballPosition;
    }
}