class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int curA = 0;
        int curB = 0;
        int curC = 0;
        StringBuilder sb = new StringBuilder();
        int n = a + b + c;
        for (int i = 0; i < n; i++) {
            if ((a >= b && a >= c && curA < 2) || (a > 0 && (curB == 2 || curC == 2))) {
                sb.append('a');
                a--;
                curB = 0;
                curC = 0;
                curA++;
            } else if ((b >= a && b >= c && curB < 2) || (b > 0 && (curA == 2 || curC == 2))) {
                sb.append('b');
                curB++;
                b--;
                curA = 0;
                curC = 0;
            } else if ((c >= a && c >= b && curC < 2) || (c > 0 && (curB == 2 || curA == 2))) {
                sb.append('c');
                curC++;
                c--;
                curB = 0;
                curA = 0;
            }
        }
        return sb.toString();
    }
}