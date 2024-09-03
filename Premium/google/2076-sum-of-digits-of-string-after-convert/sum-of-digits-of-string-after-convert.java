class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            while (num != 0) {
                sum = sum + num % 10;
                num /= 10;
            }
        }
        int num = sum;
        sum = 0;
        while (k-- > 1 && num >= 10) {

            while (num != 0) {
                sum = sum + num % 10;
                num = num / 10;
            }
            num = sum;
            sum = 0;
        }
        return num;
    }
}