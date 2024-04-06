class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 1;
        int high = removable.length;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, removable, s, p)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public boolean isPossible(int k, int[] removable, String s, String p) {
        StringBuilder sb = new StringBuilder(s);
        String afterDeletion = deleteCharacters(removable, s, k);
        return isSubsequence(afterDeletion, p);
    }

    public String deleteCharacters(int[] removable, String s, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < k; i++)
            hs.add(removable[i]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!hs.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public boolean isSubsequence(String s, String p) {
        if (p.length() > s.length())
            return false;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == p.length();
    }
}