class Solution {

    public String getHappyString(int n, int k) {

        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        char[] chars = {'a','b','c'};
        StringBuilder ans = new StringBuilder();

        char prev = '#';

        for (int i = 0; i < n; i++) {

            int remaining = n - i - 1;
            int block = 1 << remaining; // strings possible after choosing char

            for (char c : chars) {

                if (c == prev) continue;

                if (k > block) {
                    k -= block;
                } else {
                    ans.append(c);
                    prev = c;
                    break;
                }
            }
        }

        return ans.toString();
    }
}