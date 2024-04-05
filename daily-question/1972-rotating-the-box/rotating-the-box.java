class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                ans[j][i] = box[m - 1 - i][j];
        }
        for (int i = 0; i < m; i++) {
            moveStones(ans, i);
        }

        return ans;
    }

    public void moveStones(char ans[][], int col) {
        char[] temp = new char[ans.length];
        for (int i = 0; i < ans.length; i++) {
            temp[i] = ans[i][col];
        }
        int i = temp.length - 1;
        int j = i;
        while (i >= 0) {
            if (temp[i] == '*' || temp[i] == '#') {
                if (temp[i] == '*') {
                    j = i - 1;
                } else {
                    temp[i] = '.';
                    temp[j] = '#';
                    j--;
                }
            }
            i--;

        }
        for (i = 0; i < ans.length; i++) {
            ans[i][col] = temp[i];
        }
    }
}