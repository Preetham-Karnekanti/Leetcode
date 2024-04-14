class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k)
            return false;
        HashSet<String> hs = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - k + 1; i++) {
            hs.add(s.substring(i, i + k));
        }

        return hs.size() == (1 << k);
    }
}