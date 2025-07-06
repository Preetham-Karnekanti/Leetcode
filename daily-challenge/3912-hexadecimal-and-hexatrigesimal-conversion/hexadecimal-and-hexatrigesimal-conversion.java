class Solution {
    public String concatHex36(int n) {
        String ans1 = helper1(n * n);
        String ans2 = helper2(n * n * n);
        return ans1 + ans2;
    }

    public String helper1(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 16;
            if (rem < 10)
                sb.append(rem);
            else
                sb.append((char) ('A' + (rem - 10)));
            n = n / 16;
        }
        return sb.reverse().toString();
    }

    public String helper2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 36;
            if (rem < 10)
                sb.append(rem);
            else
                sb.append((char) ('A' + (rem - 10)));
            n = n / 36;
        }
        return sb.reverse().toString();
    }
}