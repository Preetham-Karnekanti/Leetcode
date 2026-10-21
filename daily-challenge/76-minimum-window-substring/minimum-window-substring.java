class Solution {
    public String minWindow(String s, String t) {
        int tFreq[] = new int[256];
        int sFreq[] = new int[256];
        int start = -1;
        int end = -1;
        for (int i = 0; i < t.length(); i++)
            tFreq[t.charAt(i)]++;
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < s.length()) {
            sFreq[s.charAt(right)]++;
            while (hasAll(sFreq, tFreq)) {
                sFreq[s.charAt(left)]--;
                if (min > right - left + 1) {
                    min = right - left + 1;
                    start = left;
                    end = right;
                }
                left++;
            }

            right++;
        }
        if(start == -1) return "";

        return s.substring(start, end + 1);
    }

    public boolean hasAll(int sFreq[], int tFreq[]) {
        for (int i = 0; i < 256; i++) {
            if (tFreq[i] == 0)
                continue;
            if (sFreq[i] < tFreq[i])
                return false;
        }
        return true;
    }
}