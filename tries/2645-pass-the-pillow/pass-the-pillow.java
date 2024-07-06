class Solution {
    public int passThePillow(int n, int time) {
        int idx = 1;
        int direction = 1;
        while (time-- > 0) {
            idx += direction;
            if (idx == n || idx == 1)
                direction *= -1;
        }
        return idx;
    }
}