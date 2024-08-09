class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);
            while (left <= right && hm.size() > k) {
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                if (hm.get(s.charAt(left)) == 0)
                    hm.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}