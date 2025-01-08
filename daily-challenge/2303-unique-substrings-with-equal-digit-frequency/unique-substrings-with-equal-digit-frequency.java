class Solution {
    public int equalDigitFrequency(String s) {
        int ans = 0;
        HashSet<String> hm = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int count[] = new int[10];
            String temp = "";
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - '0']++;
                temp += s.charAt(j);
                if (hasSame(count) && !hm.contains(temp)) {
                    ans++;
                    hm.add(temp);
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