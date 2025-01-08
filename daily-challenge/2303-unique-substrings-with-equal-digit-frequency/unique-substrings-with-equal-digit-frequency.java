class Solution {
    public int equalDigitFrequency(String s) {
        int ans = 0;
        HashSet<String> hm = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int count[] = new int[10];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - '0']++;
                if (hasSame(count) && !hm.contains(s.substring(i, j + 1))) {
                    ans++;
                    hm.add(s.substring(i, j + 1));
                }
            }
        }
        return ans;
    }

    private boolean hasSame(int count[]) {
        int prev = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                prev = count[i];
                break;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                continue;
            if (prev != count[i])
                return false;
        }
        return true;
    }
}