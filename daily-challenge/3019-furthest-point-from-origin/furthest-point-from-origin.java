class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int dash = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'L')
                l++;
            else if (ch == 'R')
                r++;
            else
                dash++;
        }
        return Math.abs(l - r) + dash;
    }
}