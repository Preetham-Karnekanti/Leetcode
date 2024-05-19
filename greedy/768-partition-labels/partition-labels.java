class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> al = new ArrayList<>();
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        int left = 0;
        int freq2[] = new int[26];
        for (int right = 0; right < s.length(); right++) {
            freq2[s.charAt(right) - 'a']++;
            if (hasAll(freq, freq2, left, right, s)) {
                al.add(right - left + 1);
                left = right;
                left++;
            }
        }
        return al;
    }

    public boolean hasAll(int freq[], int freq2[], int left, int right, String s) {
        while (left <= right) {
            if (freq[s.charAt(left) - 'a'] != freq2[s.charAt(left) - 'a'])
                return false;
            left++;
        }
        return true;
    }
}