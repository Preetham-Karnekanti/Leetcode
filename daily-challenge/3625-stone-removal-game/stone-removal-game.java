class Solution {
    public boolean canAliceWin(int n) {
        char curTurn = 'A';
        int toBeRemoved = 10;
        while (n >= toBeRemoved) {
            n -= toBeRemoved;
            toBeRemoved--;
            curTurn = curTurn == 'A' ? 'B' : 'A';
        }

        return curTurn != 'A';
    }
}