class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int[][] map = new int[s.length()][26];
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                map[i] = map[i - 1].clone();
            }
            map[i][s.charAt(i) - 'a']++;
        }

        for (int[] query : queries) {
            int start = query[0], end = query[1], k = query[2];
            int odds = 0;
            for (int i = 0; i < 26; i++) {
                if (start == 0) {
                    odds += (map[end][i]) % 2;
                } else {
                    odds += (map[end][i] - map[start - 1][i]) % 2;
                }
            }
            res.add(odds / 2 <= k);
        }
        return res;
    }
}