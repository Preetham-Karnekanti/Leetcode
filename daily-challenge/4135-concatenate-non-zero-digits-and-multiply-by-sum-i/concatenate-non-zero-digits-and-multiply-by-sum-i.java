class Solution {
    public long sumAndMultiply(int n) {
        String num = String.valueOf(n);
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                sum += (num.charAt(i) - '0');
                ans = ans * 10 + (num.charAt(i) - '0');
            }
        }
        return sum * ans;
    }
}