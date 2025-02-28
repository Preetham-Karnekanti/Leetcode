class Solution {
    public int longestRepeatingSubstring(String s) {
        int maxLen = 0;
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(s, mid)) {
                maxLen = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return maxLen;
    }

    public boolean isPossible(String s, int size) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i <= s.length() - size; i++) {
            if (hs.contains(s.substring(i, i + size)))
                return true;
            hs.add(s.substring(i, i + size));
        }
        return false;
    }
}