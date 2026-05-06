class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] answer = new char[m][n];
        for (int i = 0; i < n; i++) {
            char temp[] = moveStones(boxGrid[i]);
            for (int k = 0; k < temp.length; k++) {
                answer[k][n - 1 - i] = temp[k];
            }
        }
        return answer;
    }

    public char[] moveStones(char[] arr) {
        int n = arr.length;
        char[] temp = new char[n];
        Arrays.fill(temp, '.');

        int write = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '*') {
                temp[i] = '*';
                write = i - 1;
            } else if (arr[i] == '#') {
                temp[write--] = '#';
            }
        }

        return temp;
    }
}