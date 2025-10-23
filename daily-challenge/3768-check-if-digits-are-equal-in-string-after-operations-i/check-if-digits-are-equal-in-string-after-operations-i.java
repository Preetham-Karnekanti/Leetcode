class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 2) {
            StringBuilder sb1 = new StringBuilder();

            for (int i = 0; i < sb.length() - 1; i++) {
                int sum = sb.charAt(i) - '0' + sb.charAt(i + 1) - '0';
                sum = sum % 10;
                sb1.append(sum);
            }
            sb = sb1;
        }
        return sb.charAt(0) == sb.charAt(1);
    }
}