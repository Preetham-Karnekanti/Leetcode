class Solution {
    public int numSub(String s) {
        long ans = 0;
        long count = 0;
        int m = (int) 1e9 + 7;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                ans += (count * (count + 1)) / 2;
                count = 0;
            }
        }
        ans += (count * (count + 1)) / 2;
        return (int)(ans % m);
    }
}