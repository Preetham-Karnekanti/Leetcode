class Solution {
    static long mod = (long) 1e9 + 7;

    public static int[] productQueries(int n, int[][] queries) {
        String s = Integer.toBinaryString(n);
        ArrayList<Long> arr = new ArrayList<>();
        int cur = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                arr.add(((long) Math.pow(2, cur)) % mod);
            }
            cur++;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long temp = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                temp = (arr.get(j) * temp) % mod;
            }
            result[i] = (int) (temp % mod);
        }
        return result;
    }
}