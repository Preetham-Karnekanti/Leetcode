class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);
            while (hm.size() > 2) {
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