class Solution {
    public int countTime(String time) {
        int pForIdx0 = 1;
        int pForIdx1 = 1;
        int pForIdx3 = 1;
        int pForIdx4 = 1;
        if (time.charAt(3) == '?')
            pForIdx3 = 6;
        if (time.charAt(4) == '?')
            pForIdx4 = 10;
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            return 24 * pForIdx3 * pForIdx4;
        }
        if (time.charAt(0) == '?') {
            if (time.charAt(1) <= '3')
                return 3 * pForIdx3 * pForIdx4;
            else
                return 2 * pForIdx3 * pForIdx4;
        }
        if (time.charAt(1) == '?') {
            if (time.charAt(0) == '2')
                return 4 * pForIdx3 * pForIdx4;
            else
                return 10 * pForIdx3 * pForIdx4;
        }
        return pForIdx0 * pForIdx1 * pForIdx3 * pForIdx4;
    }
}