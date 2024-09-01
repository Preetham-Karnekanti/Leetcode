class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char color1 = getColor(coordinate1);
        char color2 = getColor(coordinate2);
        System.out.println(color1);
        System.out.println(color2);
        return color1 == color2;
    }

    public char getColor(String s) {
        int a = s.charAt(0) - 'a' + 1;
        int num = s.charAt(1) - '0';
        if (a % 2 == num % 2)
            return 'b';
        return 'w';
    }
}